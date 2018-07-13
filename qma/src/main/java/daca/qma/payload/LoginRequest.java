package daca.qma.payload;

import javax.validation.constraints.NotBlank;

/**
 * define what login will be and what fields
 * @author lucas_wilker
 *
 */

public class LoginRequest {
	
	@NotBlank
    private String matricula;

    @NotBlank
    private String senha;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

    
}
