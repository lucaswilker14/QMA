package daca.qma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import daca.qma.models.Aluno;
import daca.qma.models.Tutor;
import daca.qma.services.AlunoService;
import daca.qma.services.TutorService;

@RestController
@RequestMapping("/qma/tutor")
public class TutorRestController {

	@Autowired
	private AlunoService as;
	
	@Autowired
	private TutorService ts;

	// US-2 - DEFINICAO DOS TUTORES

	// Tornar Aluno um Tutor
	//ver a possibilidade de só passar a matricula e recuperar o aluno
	@PostMapping("/tornarTutor")
	public Tutor tornarTutor(@RequestBody @Valid Tutor obj) {
		Aluno aluno = as.findByMatricula(obj.getMatricula());
		if (aluno != null) {
			obj.setAluno_tutor(aluno);
			return ts.tornarTutor(obj);
		} else {
			// retorna uma messagem de erro dizendo que o aluno não existe pra
			// ser tutor e tal...
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
	public String deleteTutor(@PathVariable("matricula") String matricula){
		return ts.delete(matricula);	
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll(){
		return ts.deleteAll();
	}
}
