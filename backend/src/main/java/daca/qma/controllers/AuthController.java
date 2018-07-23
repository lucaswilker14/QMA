
package daca.qma.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import daca.qma.models.Aluno;
import daca.qma.payload.ApiResponse;
import daca.qma.payload.JwtAuthenticationResponse;
import daca.qma.payload.LoginRequest;
import daca.qma.payload.SignUpRequest;
import daca.qma.repository.AlunoRepository;
import daca.qma.security.JwtTokenProvider;
import daca.qma.services.AlunoService;

@RestController
@RequestMapping("/qma/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private AlunoService as;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	// LOGIN
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		if (!(as.verificaMatricula(loginRequest.getMatricula()))) {
			return new ResponseEntity(new ApiResponse(false, "Matricula Inválida!"), HttpStatus.BAD_REQUEST);
		}
		
		boolean a = passwordEncoder.matches(loginRequest.getSenha(), as.findByMatricula(loginRequest.getMatricula()).getSenha());
		
		if (!a) {
			return new ResponseEntity(new ApiResponse(false, "Senha Inválida!"), HttpStatus.BAD_REQUEST);
		}
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMatricula(), loginRequest.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	// CADASTRAR ALUNO NO SISTEMA
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		
		if (as.verificaMatricula(signUpRequest.getMatricula())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}
		
		if (as.verificaEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		Aluno aluno = new Aluno(signUpRequest.getMatricula(), signUpRequest.getNome_aluno(),
				signUpRequest.getCodigo_curso(), signUpRequest.getTelefone(), signUpRequest.getEmail(),
				signUpRequest.getSenha());

		aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));

		Aluno result = as.cadastrar(aluno);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/qma/aluno/{matricula}")
				.buildAndExpand(result.getMatricula()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Aluno registered successfully"));
	}

}
