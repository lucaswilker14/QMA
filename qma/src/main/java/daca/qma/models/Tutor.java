package daca.qma.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="table_tutor")
public class Tutor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String disciplina;
	
	private float proficiencia;
	
	private float nota_avaliacao_tutor = 4;
	
	private float dinheiro = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public float getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(float proficiencia) {
		this.proficiencia = proficiencia;
	}

	public float getNota_avaliacao() {
		return nota_avaliacao_tutor;
	}

	public void setNota_avaliacao(float nota_avaliacao) {
		this.nota_avaliacao_tutor = nota_avaliacao;
	}

	public float getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
