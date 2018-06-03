package daca.qma.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="table_Aluno")
public class Aluno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String nome_aluno;
	
	@NotBlank
	private String codigo_curso;
	
	@Size(min=8, max=8)
	private String telefone;
	
	@NotBlank @Email
	private String email;

	private float nota_avaliacao = 5;

	//	public Aluno(String matricula, String nome_aluno, String codigo_curso, String telefone, String email){
//		
//		this.matricula = matricula;
//		this.nome_aluno = nome_aluno;
//		this.codigo_curso = codigo_curso;
//		this.telefone = telefone;
//		this.email = email;
//		this.nota_avalicao = 5;
//	}
//	
//	public Aluno(String matricula, String nome_aluno, String codigo_curso, String email){
//		
//		this.matricula = matricula;
//		this.nome_aluno = nome_aluno;
//		this.codigo_curso = codigo_curso;
//		this.email = email;
//		this.nota_avalicao = 5;
//	}
//	
	@Override
	public String toString() {
		String impressao;
		if (this.telefone != null) {
			impressao = this.matricula + " - " + this.nome_aluno + " - " + this.codigo_curso + " - " + this.telefone + " - " + this.email + " " + this.nota_avaliacao; 
			return impressao;			
		}else {
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
}
