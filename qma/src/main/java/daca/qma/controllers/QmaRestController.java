package daca.qma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import daca.qma.models.Aluno;
import daca.qma.models.Tutor;
import daca.qma.services.AlunoService;
import daca.qma.services.TutorService;

@RestController
@RequestMapping("/qma")
public class QmaRestController {
	
	@Autowired
	private AlunoService as;
	
	@Autowired
	private TutorService ts;
	
	//Create - POST
	@PostMapping("/cadastrarAluno")
	public Aluno cadastrarAluno(@RequestBody @Valid Aluno aluno){
		return as.cadastraAluno(aluno);
	}
	
	//Read - GET ALL
	@GetMapping(produces="application/json")
	public @ResponseBody List<Aluno> retornarAlunos(){
		return as.findAllAluno();
	}
	
	//Read - GET MATRICULA
	@GetMapping("/{matricula}")
	public Aluno buscarAlunoMatricula(@PathVariable("matricula") String matricula){
		return as.findByMatricula(matricula);
	}
	
	//Update - PUT
	@PutMapping("/editarAluno/{matricula}")
	public Aluno editarAluno(@PathVariable("matricula") String matricula, @RequestBody @Valid Aluno aluno){
		Aluno novo_aluno = as.findByMatricula(matricula);
		return as.updateAluno(novo_aluno, aluno);
		
	}
	
	
	//Delete - DELETE
	@DeleteMapping()
	public String deletarAluno(@RequestBody @Valid Aluno aluno){
		return as.deleteAluno(aluno);
	}
	

	//US-2 - DEFINICAO DOS TUTORES
	
	//Tornar Aluno um Tutor
	@PostMapping("/tornarTutor")
	public Tutor tornarTutor(@RequestBody @Valid Tutor obj){
		//criando o tutor e retornando		
		return ts.tornarTutor(obj);
	}
	
	@GetMapping("/tutor/{matricula}")
	public Tutor buscarTutorMatricula(@PathVariable("matricula") String matricula_tutor){
		return ts.findByMatricula(matricula_tutor);
	}
	
	@GetMapping("/tutores")
	public @ResponseBody List<Tutor> retornarTutores(){
		return ts.findAllTutores();
	}
}
