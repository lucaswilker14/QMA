package daca.qma.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import daca.qma.services.AlunoDetailsService;

/**
 * 
 * @author lucas_wilker
 *
 * Main class for the token. Get the request token, validate it, oad the user associated with the token, and pass it to Spring Security
 */

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private AlunoDetailsService ads;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String jwt = getJwtFromRequest(req);

			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				Long alunoId = tokenProvider.getUserIdFromJWT(jwt);

				AlunoPrincipal alunoPrincipal = ads.loadUserById(alunoId);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						alunoPrincipal, null, alunoPrincipal.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception ex) {
			logger.error("Could not set user authentication in security context", ex);
		}

		filterChain.doFilter(req, res);

	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

}
