package daca.qma.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author lucas_wilker
 * define what login will be and what fields
 */

public class SignUpRequest {

	@NotBlank
    @Size(min=9, max = 9)
	private String matricula;
	
	@NotBlank
	@Size(min=3, max = 30)
	private String nome_aluno;
	
	@NotBlank
	@Size(min=5, max = 5)
	private String codigo_curso;
	
	@Size(min=10, max=11)
	private String telefone;
	
	@NotBlank @Email
	@Size(max=40)
	private String email;

	@NotBlank
    @Size(min=6)
    private String senha;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
