package daca.qma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daca.qma.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findByid(Long id);
	
	Aluno findByMatricula(String matricula);
	
}
