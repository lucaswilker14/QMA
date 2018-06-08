package daca.qma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daca.qma.models.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{
	Tutor findByMatricula(String matricula);
}
