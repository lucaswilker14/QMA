package daca.qma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import daca.qma.exception.TutorRegistrationException;
import daca.qma.models.Aluno;
import daca.qma.models.Tutor;
import daca.qma.payload.ApiResponse;
import daca.qma.security.AlunoPrincipal;
import daca.qma.security.CurrentUser;
import daca.qma.services.AlunoService;
import daca.qma.services.TutorService;

@RestController
@RequestMapping("/qma/tutor")
public class TutorRestController {

	@Autowired
	private AlunoService as;

	@Autowired
	private TutorService ts;

	@PostMapping("/tornarTutor")
	public Tutor tornarTutor(@RequestBody @Valid Tutor obj, @CurrentUser AlunoPrincipal alunoP)
			throws TutorRegistrationException {

		// consulta pra saber se o aluno ja eh um tutor
		boolean isTutor = as.findByMatricula(alunoP.getUsername()).isTutor();

		if (!isTutor) {

			if (alunoP != null) {

				// cria tutor
				Tutor tutor = new Tutor(alunoP.getUsername(), obj.getDisciplina(), obj.getProficiencia());
				// recupera aluno pela matricula
				Aluno aluno = as.findByMatricula(alunoP.getUsername());

				// seta pra true pois eh um TUTOR
				aluno.setTutor(true);
				// salva no bd
				as.cadastrar(aluno);

				// seta o aluno_tutor
				tutor.setAluno_tutor(aluno);
				// salva
				return ts.tornarTutor(tutor);

			} else {
				return null;
			}
		} else {
			// retorna uma exception dizendo que ele ja é tutor
			return null;
		}
	}

	@GetMapping("/{matricula}")
	public Tutor buscarTutorMatricula(@PathVariable("matricula") String matricula_tutor) {
		return ts.findByMatricula(matricula_tutor);
	}

	@GetMapping("/all")
	public @ResponseBody List<Tutor> retornarTutores() {
		return ts.findAll();
	}

	@DeleteMapping("/{matricula}")
	public String deleteTutor(@PathVariable("matricula") String matricula) {
		as.findByMatricula(matricula).setTutor(false);
		return ts.delete(matricula);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return ts.deleteAll();
	}
}
