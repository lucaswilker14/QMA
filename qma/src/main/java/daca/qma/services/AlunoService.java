package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Aluno;
import daca.qma.repository.AlunoRepository;
import daca.qma.util.Crud;

@Service
public class AlunoService implements /*AlunoServiceInterface*/ Crud<Aluno> {

	@Autowired
	private AlunoRepository ar;
	
	//POST
	@Override
	public Aluno cadastrar(Aluno aluno) {
		return ar.save(aluno);
	}

	@Override
	public List<Aluno> findAll() {
		return ar.findAll();
	}

	@Override
	public Aluno findByid(Long id) {
		return ar.findByid(id);
	}
	
	@Override
	public Aluno findByMatricula(String matricula) {
		return ar.findByMatricula(matricula);
	}

	@Override
	public Aluno update(Aluno novo_aluno, Aluno aluno) {
		novo_aluno.setMatricula(aluno.getMatricula());
		novo_aluno.setNome_aluno(aluno.getNome_aluno());
		novo_aluno.setCodigo_curso(aluno.getCodigo_curso());
		novo_aluno.setTelefone(aluno.getTelefone());
		novo_aluno.setEmail(aluno.getEmail());
		return ar.save(novo_aluno);
	}
	
	@Override
	public String delete(String matricula) {
		Aluno aluno = ar.findByMatricula(matricula);
		ar.delete(aluno);
		return "ALUNO DELETADO";
	}

	@Override
	public String deleteAll() {
		ar.deleteAll();
		return "ALUNOS DELETADOS";
	}
	
	public boolean verificaEmail(String email) {
		return ar.existsByEmail(email);
	}
	
	public boolean verificaMatricula(String email) {
		return ar.existsByMatricula(email);
	}
}
