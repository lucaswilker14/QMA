package daca.qma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daca.qma.models.Aluno;
import daca.qma.repository.AlunoRepository;
import daca.qma.util.Crud;

@Service
public class AlunoService implements /* AlunoServiceInterface */ Crud<Aluno> {

	@Autowired
	private AlunoRepository ar;

	// POST
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

	public Aluno findByMatriculaOrEmail(String matriculaOrEmail) {
		return ar.findByMatriculaOrEmail(matriculaOrEmail, matriculaOrEmail);
	}

	@Override
	public Aluno update(Aluno novo_aluno, Aluno aluno) {

		if (aluno.getMatricula() != null) {
			novo_aluno.setMatricula(aluno.getMatricula());
		}

		if (aluno.getNome_aluno() != null) {
			novo_aluno.setNome_aluno(aluno.getNome_aluno());
		}

		if (aluno.getCodigo_curso() != null) {
			novo_aluno.setCodigo_curso(aluno.getCodigo_curso());
		}

		if (aluno.getTelefone() != null) {
			novo_aluno.setTelefone(aluno.getTelefone());
		}

		if (aluno.getEmail() != null) {
			novo_aluno.setEmail(aluno.getEmail());
		}

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
