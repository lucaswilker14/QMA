package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Tutor;
import daca.qma.repositoy.TutorRepository;
import daca.qma.util.Crud;

@Service
public class TutorService implements TutorServiceInterface, Crud<Tutor> {

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
	public List<Tutor> findAll() {
		return tr.findAll();
	}

	@Override
	public String deleteAll() {
		tr.deleteAll();
		return "Tutores Deletados";
	}

	@Override
	public Tutor cadastrar(Tutor objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tutor findByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tutor update(Tutor obj1, Tutor obj2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}


}
