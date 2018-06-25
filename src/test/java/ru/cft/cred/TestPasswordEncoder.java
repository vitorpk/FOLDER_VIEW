package ru.cft.cred;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class TestPasswordEncoder {

	public static void main(String[] args) {
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Map encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder(11));
		encoders.put("noop", NoOpPasswordEncoder.getInstance());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		encoders.put("sha256", new StandardPasswordEncoder());

		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

		//System.out.println(passwordEncoder.encode("babiiv"));

		if (passwordEncoder.matches("babiiv", "{bcrypt}$2a$11$JeU4JVHIdSBxv79IIJxbhOZjKp1Yk0jXlgesXjJflVXO54q6/ro2m")) {
			System.out.println("match");
		}
	}

}
