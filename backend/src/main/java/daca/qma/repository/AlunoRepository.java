package daca.qma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daca.qma.models.Aluno;
import java.lang.String;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findByid(Long id);

	Aluno findByMatricula(String matricula);

	Aluno findByMatriculaOrEmail(String matricula, String email);

	boolean existsByMatricula(String matricula);

	boolean existsByEmail(String email);
}
