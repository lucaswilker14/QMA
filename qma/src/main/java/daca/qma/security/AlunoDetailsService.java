package daca.qma.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import daca.qma.models.Aluno;
import daca.qma.repository.AlunoRepository;

@Service
public class AlunoDetailsService implements UserDetailsService {

	@Autowired
	AlunoRepository ar;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String matriculaOrEmail) throws UsernameNotFoundException {
		
//		Aluno aluno = ar.findByMatricula(matricula);
		Aluno aluno = ar.findByMatriculaOrEmail(matriculaOrEmail, matriculaOrEmail);
		return AlunoPrincipal.create(aluno);
				
	}
	
	// This method is used by JWTAuthenticationFilter
    @Transactional
    public AlunoPrincipal loadUserById(Long id) {
        Aluno aluno = ar.findByid(id);
        return AlunoPrincipal.create(aluno);
    }

}
