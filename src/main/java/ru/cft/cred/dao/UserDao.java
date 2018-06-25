package ru.cft.cred.dao;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

import ru.cft.cred.entities.Role;
import ru.cft.cred.entities.User;

@Component
public class UserDao {
	// заглушка для Dao
	
	private User user = User.builder()
			.username("user")
			.password("$2a$11$i935nq/SkxzChGGaEE3wY.4mqaC0e9JtYBdSr6GaLlSyJY0JsyBo2") //password
			.authorities(ImmutableList.of(Role.USER))
			.accountNonExpired(true)
			.accountNonLocked(true)
			.credentialsNonExpired(true)
			.enabled(true)
			.build();
	
	private User babiiv = User.builder()
			.username("babiiv")
			.password("$2a$11$JeU4JVHIdSBxv79IIJxbhOZjKp1Yk0jXlgesXjJflVXO54q6/ro2m") //babiiv
			.authorities(ImmutableList.of(Role.USER))
			.accountNonExpired(true)
			.accountNonLocked(true)
			.credentialsNonExpired(true)
			.enabled(true)
			.build();

	public User findByUsername(String username) {
		switch (username) {
			case "user" :
				return user;
			case "babiiv" :
				return babiiv;
			default :
				return null;
		}
	}
	
	public User findById(long id) {
		if (id == 1)
			return user;
		else if (id == 2)
			return babiiv;
		else
			return null;
	}
}
