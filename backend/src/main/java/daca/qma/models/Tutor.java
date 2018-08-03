package daca.qma.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_tutor")
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	 @NotBlank
	private String matricula;

	@NotBlank
	private String disciplina;

	@NotNull
	@Range(min = 1, max = 5)
	private float proficiencia;

	private float nota_aval_tutor = 4;

	private float dinheiro = 0;
	
	@OneToOne
	private Ajuda pedido_ajuda;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "tb_aluno_tutor", joinColumns = @JoinColumn(name = "fk_tutor_id"), inverseJoinColumns = @JoinColumn(name = "fk_aluno_id"))
	private Aluno aluno_tutor;

	
	public Tutor() {
	}

	public Tutor(String matricula, String disciplina, float proficiencia) {

		this.matricula = matricula;
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
	}

	// @Override
	// public String toString() {
	// String impressao;
	// impressao = this.matricula + " - " + this.disciplina + " - " +
	// this.proficiencia;
	// return impressao;
	// }

	@Override
	public String toString() {
		String impressao;
		impressao = this.matricula + " - " + this.disciplina + " - " + this.proficiencia;
		return impressao;
	}
	
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

	public float getNota_aval_tutor() {
		return nota_aval_tutor;
	}

	public void setNota_aval_tutor(float nota_avaliacao_tutor) {
		this.nota_aval_tutor = nota_avaliacao_tutor;
	}

	public float getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}

	public Aluno getAluno_tutor() {
		return aluno_tutor;
	}

	public void setAluno_tutor(Aluno aluno_tutor) {
		this.aluno_tutor = aluno_tutor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ajuda getPedido_ajuda() {
		return pedido_ajuda;
	}

	public void setPedido_ajuda(Ajuda pedido_ajuda) {
		this.pedido_ajuda = pedido_ajuda;
	}
	
	

}
