package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Ajuda;
import daca.qma.repository.AjudaRepository;
import daca.qma.util.Crud;

@Service
public class AjudaService implements Crud<Ajuda>{

	@Autowired
	private AjudaRepository ar;
	
	@Override
	public Ajuda cadastrar(Ajuda ajuda) {
		return ar.save(ajuda);
	}

	@Override
	public List<Ajuda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ajuda> findAllByDisciplina(String disciplina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ajuda findByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ajuda findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ajuda update(Ajuda obj1, Ajuda obj2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}
