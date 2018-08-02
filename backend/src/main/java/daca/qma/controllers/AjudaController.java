package daca.qma.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daca.qma.models.Ajuda;
import daca.qma.models.Tutor;

@RestController
@RequestMapping("/qma/ajuda")
public class AjudaController {

	
//	private AjudaService ajuda_ser;
	
	@PostMapping("/{matricula}")
	public Ajuda ajudaPresencial(String matricula_aluno, String disciplina, String horario) {
		return null;
	}
	
	@PostMapping("/{matricula}")
	public Ajuda ajudaOnline(String matricula_aluno, String email) {
		return null;
	}
	
	private Tutor buscarTutor(String disciplina) {
		return null;
	}
}
