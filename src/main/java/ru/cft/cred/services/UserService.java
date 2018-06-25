package ru.cft.cred.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.cft.cred.dao.UserDao;
import ru.cft.cred.entities.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.length() == 0)
			throw new UsernameNotFoundException("Empty username");

		User user = userDao.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User " + username + " not found");
		return user;
	}
	
	public User findById(long id) {
		return userDao.findById(id);
	}

}
