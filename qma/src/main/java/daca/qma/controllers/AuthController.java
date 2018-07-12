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

@RestController
@RequestMapping("/qma/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	// LOGIN
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMatricula(), loginRequest.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	// CADASTRAR ALUNO NO SISTEMA
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		if (alunoRepository.existsByMatricula(signUpRequest.getMatricula())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (alunoRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Aluno aluno = new Aluno(signUpRequest.getMatricula(), signUpRequest.getNome_aluno(),
				signUpRequest.getCodigo_curso(), signUpRequest.getTelefone(), signUpRequest.getEmail(), signUpRequest.getSenha());

		aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));

		Aluno result = alunoRepository.save(aluno);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/qma/aluno/{matricula}")
				.buildAndExpand(result.getMatricula()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Aluno registered successfully"));
	}

}
