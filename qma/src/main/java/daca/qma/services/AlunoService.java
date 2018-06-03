package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Aluno;
import daca.qma.repositoy.AlunoRepository;

@Service
public class AlunoService implements AlunoServiceInterface {

	@Autowired
	private AlunoRepository ar;
	
	//POST
	@Override
	public Aluno cadastraAluno(Aluno aluno) {
		return ar.save(aluno);
	}

	@Override
	public List<Aluno> findAllAluno() {
		return ar.findAll();
	}

	@Override
	public Aluno findById(Long id) {
		return ar.findByid(id);
	}
	
	@Override
	public Aluno findByMatricula(String matricula) {
		return ar.findByMatricula(matricula);
	}

	@Override
	public Aluno updateAluno(Aluno novo_aluno, Aluno aluno) {
		novo_aluno.setMatricula(aluno.getMatricula());
		novo_aluno.setNome_aluno(aluno.getNome_aluno());
		novo_aluno.setCodigo_curso(aluno.getCodigo_curso());
		novo_aluno.setTelefone(aluno.getTelefone());
		novo_aluno.setEmail(aluno.getEmail());
		return ar.save(aluno);
	}
	
	@Override
	public String deleteAluno(Aluno aluno) {
		ar.delete(aluno);
		return "ALUNO DELETADO";
	}

}
