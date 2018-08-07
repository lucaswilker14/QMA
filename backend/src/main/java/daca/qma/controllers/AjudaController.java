package daca.qma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daca.qma.models.Ajuda;
import daca.qma.models.AjudaTipo;
import daca.qma.models.Aluno;
import daca.qma.models.Tutor;
import daca.qma.services.AjudaService;
import daca.qma.services.AlunoService;
import daca.qma.services.TutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Api(value="REST API - Solicitacao de Ajuda")
@RestController
@RequestMapping("/qma/ajuda")
public class AjudaController {

	// private AjudaService ajuda_ser;

	@Autowired
	private TutorService ts;

	@Autowired
	private AlunoService as;

	@Autowired
	private AjudaService ajuda_ser;

	@ApiOperation(value="Solicitacao de ajuda do aluno por meio do tipo presencial")
	@PostMapping("/presencial/{matricula}")
	public Ajuda ajudaPresencial(@PathVariable("matricula") String matricula_aluno, @RequestBody Ajuda ajuda_detalhe) {
		return process(matricula_aluno, ajuda_detalhe, AjudaTipo.PRESENCIAL.getTipo());
	}

	@ApiOperation(value="Solicitacao de ajuda do aluno por meio do tipo Online", notes="Não requer informações de horário")
	@PostMapping("/online/{matricula}")
	public Ajuda ajudaOnline(@PathVariable("matricula") String matricula_aluno, @RequestBody Ajuda ajuda_detalhe) {
		return process(matricula_aluno, ajuda_detalhe, AjudaTipo.ONLINE.getTipo());
	}

	private Tutor buscarTutor(String disciplina) {

		List<Tutor> tutores_byDisciplina = ts.findAllByDisciplina(disciplina);

		if (tutores_byDisciplina.isEmpty()) {
			return null;
		}

		float menor_prof = 0;
		Tutor tutor_maior = tutores_byDisciplina.get(0);

		for (Tutor tutor : tutores_byDisciplina) {
			if (tutor.getProficiencia() > menor_prof) {
				menor_prof = tutor.getProficiencia();
				tutor_maior = tutor;
			}
		}

		return tutor_maior;
	}

	
	private Ajuda process(String matricula_aluno, Ajuda ajuda_detalhe, String tipo) {

		Aluno aluno_ajuda = as.findByMatricula(matricula_aluno);
		Tutor t = buscarTutor(ajuda_detalhe.getDisciplina());

		if (aluno_ajuda.getPedido_ajuda() == null) { // se o aluno nao tiver um
														// pedido de ajuda ja
														// cadastrado

			ajuda_detalhe.setAjudaTipo(tipo);
			ajuda_detalhe.setAluno_ajuda(aluno_ajuda);
			ajuda_detalhe.setTutor_ajuda(t);

			Ajuda ajudaP = ajuda_ser.cadastrar(ajuda_detalhe);

			aluno_ajuda.setPedido_ajuda(ajudaP);
			t.setPedido_ajuda(ajudaP);

			as.cadastrar(aluno_ajuda);
			ts.cadastrar(t);

			return ajudaP;
		}

		return null;
	}
}
