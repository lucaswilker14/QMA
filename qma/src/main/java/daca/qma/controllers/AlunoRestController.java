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
import daca.qma.services.AlunoService;

@RestController
@RequestMapping("/qma/aluno")
public class AlunoRestController {
	
	//US1 - CRUD ALUNO
	
	@Autowired
	private AlunoService as;
	
	//Create - POST
	@PostMapping("/cadastrarAluno")
	public Aluno cadastrarAluno(@RequestBody @Valid Aluno aluno){
		return as.cadastrar(aluno);
	}
	
	//Read - GET ALL
	@GetMapping(value = "/listagem",  produces="application/json")
	public @ResponseBody List<Aluno> retornarAlunos(){
		return as.findAll();
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
		return as.update(novo_aluno, aluno);
		
	}
	
	//Delete - DELETE
	@DeleteMapping("/{matricula}")
	public String deletarAluno(@PathVariable("matricula") String matricula){
		return as.delete(matricula);
	}
	
	//Delete ALL
	@DeleteMapping("/deleteAll")
	public String deleteAll(){
		return as.deleteAll();
	}
}
