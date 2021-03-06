package daca.qma.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Modelo - Aluno")
@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Matricula do Aluno")
	@NotBlank
	@Column(name = "Matricula")
	private String matricula;

	@ApiModelProperty(value = "Nome completo do Aluno")
	@NotBlank
	@Column(name = "Nome_Aluno")
	private String nome_aluno;

	@ApiModelProperty(value = "Codigo do Curso")
	@NotBlank
	@Column(name = "Codigo_Curso")
	private String codigo_curso;

	@ApiModelProperty(value = "Telefone do Aluno")
	@Size(min = 10, max = 10)
	@Column(name = "Telefone")
	private String telefone;

	@ApiModelProperty(value = "Email")
	@NotBlank
	@Email
	@Column(name = "Email")
	private String email;

	@ApiModelProperty(value = "Nota de avaliacao do aluno retornadas pelos os Tutores")
	@Column(name = "Nota_Avalicao")
	private float nota_avaliacao = 5;

	@ApiModelProperty(value = "Senha para logar no sistema")
	@JsonIgnore
	@NotBlank
	private String senha;

	@ApiModelProperty(value = "Se um aluno eh tutor ou nao")
	@Column(name = "isTutor")
	private boolean isTutor;

	@OneToOne
	private Ajuda pedido_ajuda;

	// @ManyToMany
	// @JoinTable(name = "tb_alunos_tutores", joinColumns = @JoinColumn(name =
	// "aluno_id"), inverseJoinColumns = @JoinColumn(name = "tutor_id "))
	// private List<Tutor> tutores = new ArrayList<Tutor>();

	public Aluno(String matricula, String nome_aluno, String codigo_curso, String telefone, String email,
			String senha) {

		this.matricula = matricula;
		this.nome_aluno = nome_aluno;
		this.codigo_curso = codigo_curso;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public Aluno() {
	}

	@Override
	public String toString() {
		String impressao;
		if (this.telefone != null) {
			impressao = this.matricula + " - " + this.nome_aluno + " - " + this.codigo_curso + " - " + this.telefone
					+ " - " + this.email + " " + this.nota_avaliacao;
			return impressao;
		} else {
			impressao = this.matricula + " - " + this.nome_aluno + " - " + this.codigo_curso + " - " + this.email;
			return impressao;
		}
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

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public String getCodigo_curso() {
		return codigo_curso;
	}

	public void setCodigo_curso(String codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getNota_avaliacao() {
		return nota_avaliacao;
	}

	public void setNota_avaliacao(float nota_avaliacao) {
		this.nota_avaliacao = nota_avaliacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isTutor() {
		return isTutor;
	}

	public void setTutor(boolean isTutor) {
		this.isTutor = isTutor;
	}

	public Ajuda getPedido_ajuda() {
		return pedido_ajuda;
	}

	public void setPedido_ajuda(Ajuda pedido_ajuda) {
		this.pedido_ajuda = pedido_ajuda;
	}

}
