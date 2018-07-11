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

	

	
	public AlunoPrincipal(Long id, String nome, String matricula, String email, String senha
			/*Collection<? extends GrantedAuthority> authorities*/) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.senha = senha;
//		this.authorities = authorities;
	}


	public static AlunoPrincipal create(Aluno aluno) {
       
        return new AlunoPrincipal(
                aluno.getId(),
                aluno.getNome_aluno(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getSenha()
//                authorities
        );
    }
	
	
   
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.matricula;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
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
