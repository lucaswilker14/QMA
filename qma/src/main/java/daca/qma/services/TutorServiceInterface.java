package daca.qma.services;

import java.util.List;

import daca.qma.models.Tutor;

public interface TutorServiceInterface {

	//post - create
	Tutor tornarTutor(Tutor tutor);
	
	//get matricula - read
	Tutor findByMatricula(String matricula);
		
	//get all - read
	List<Tutor> findAllTutores();
	
}
