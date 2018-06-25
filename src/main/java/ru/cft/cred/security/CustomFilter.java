package ru.cft.cred.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import ru.cft.cred.services.TokenAuthService;

//@Component
public class CustomFilter extends GenericFilterBean {

	//@Autowired
	private TokenAuthService tokenAuthService;
	//private UserService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//User user = (User) userService.loadUserByUsername("babiiv");
		//SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(user));

		SecurityContextHolder.getContext()
				.setAuthentication(tokenAuthService.getAuthentication((HttpServletRequest) request));

		chain.doFilter(request, response);
	}

}
