package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Tutor;
import daca.qma.repositoy.TutorRepository;

@Service
public class TutorService implements TutorServiceInterface {

	@Autowired
	private TutorRepository tr;
	
	@Override
	public Tutor tornarTutor(Tutor tutor) {
		return tr.save(tutor);
	}

	@Override
	public Tutor findByMatricula(String matricula) {
		return tr.findByMatricula(matricula);
	}

	@Override
	public List<Tutor> findAllTutores() {
		return tr.findAll();
	}

}
