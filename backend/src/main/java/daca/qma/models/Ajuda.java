package daca.qma.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Modelo - Ajuda")
@Entity
@Table(name="tb_ajuda")
public class Ajuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(value="Aluno que solicita a ajuda")
	@OneToOne
	private Aluno aluno_ajuda; //aluno que pediu a ajuda
	
	@ApiModelProperty(value="Tutor que é escolhido para ajudar o aluno")
	@OneToOne
	private Tutor tutor_ajuda; //tutor que vai ajudar o aluno
	
	@ApiModelProperty(value="Disciplina que o aluno necessita de ajuda")
	@NotBlank
	private String disciplina;
	
	@ApiModelProperty("Horario da ajuda")
	private String horario;
	
	@ApiModelProperty("Local da ajuda")
	private String local;
	
	@ApiModelProperty("Tipo da ajuda podendo ser Presencial ou Online")
	private String ajudaTipo;
	
	public Ajuda(){}
	
	//presencial
	public Ajuda(Aluno aluno_ajuda, Tutor tutor_ajuda, String disciplina, String horario, String local, String ajudaTipo){
		this.aluno_ajuda = aluno_ajuda;
		this.tutor_ajuda = tutor_ajuda;
		this.disciplina = disciplina;
		this.horario = horario;
		this.local = local;
		this.ajudaTipo = ajudaTipo;
	}
	
	//online
	public Ajuda(Tutor tutor, String ajudaTipo){
		this.tutor_ajuda = tutor;
		this.ajudaTipo = ajudaTipo;
		this.local = "Hangout";
	}


	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Aluno getAluno_ajuda() {
		return aluno_ajuda;
	}

	public void setAluno_ajuda(Aluno aluno_ajuda) {
		this.aluno_ajuda = aluno_ajuda;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getAjudaTipo() {
		return ajudaTipo;
	}
	public void setAjudaTipo(String ajudaTipo) {
		this.ajudaTipo = ajudaTipo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@JsonIgnore
	public Tutor getTutor_ajuda() {
		return tutor_ajuda;
	}

	public void setTutor_ajuda(Tutor tutor_ajuda) {
		this.tutor_ajuda = tutor_ajuda;
	}
	
}
