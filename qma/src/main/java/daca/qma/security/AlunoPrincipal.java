package daca.qma.security;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import daca.qma.models.Aluno;

public class AlunoPrincipal implements UserDetails {

	private Long id;

	private String nome;

	private String matricula;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String senha;

	private Collection<? extends GrantedAuthority> authorities;

	
	public AlunoPrincipal(Long id, String nome, String matricula, String email, String senha,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.senha = senha;
		this.authorities = authorities;
	}


	public static AlunoPrincipal create(Aluno aluno) {
       
        return new AlunoPrincipal(
                aluno.getId(),
                aluno.getNome_aluno(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getSenha(),
                null
                
        );
    }
	
	
   
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
		
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	
	@Override
	public String getUsername() {
		return this.matricula;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoPrincipal that = (AlunoPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
