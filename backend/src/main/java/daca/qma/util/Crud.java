package daca.qma.util;

import java.util.List;

public interface Crud<T> {

	// post
	T cadastrar(T objeto);

	// getAll
	List<T> findAll();

	//getAllByDisciplina
	List<T> findAllByDisciplina(String disciplina);
	
	// getId
	T findByid(Long id);

	// getMatricula
	T findByMatricula(String matricula);

	// update
	T update(T obj1, T obj2);

	// delete
	String delete(String matricula);

	// deleteAll
	String deleteAll();

}
