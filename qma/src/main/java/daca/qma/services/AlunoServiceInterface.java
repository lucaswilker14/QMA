package daca.qma.services;

import java.util.List;

import daca.qma.models.Aluno;

public interface AlunoServiceInterface {
	
	//post - create
	Aluno cadastraAluno(Aluno aluno);
	
	//get all - read
	List<Aluno> findAllAluno();
	
	//get id - read
	Aluno findById(Long id);
	
	//get matricula - read
	Aluno findByMatricula(String matricula);
	
	//put
	Aluno updateAluno(Aluno novo_aluno, Aluno aluno);
	
	//delete
	String deleteAluno(Aluno e);


}
