package ru.cft.cred.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ru.cft.cred.security.CustomFilter;
import ru.cft.cred.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;

	//@Autowired
	CustomFilter customFilter;

	//	@Bean
	//	public UserDetailsService userDetailsService() {
	//		// ensure the passwords are encoded properly
	//		UserBuilder users = User.withDefaultPasswordEncoder();
	//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	//		manager.createUser(users.username("user").password("password").roles("USER").build());
	//		manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
	//		return manager;
	//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers("/static/**", "/login", "/logout").permitAll()
				.anyRequest().authenticated()
				.and()
			//.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	//			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
}
