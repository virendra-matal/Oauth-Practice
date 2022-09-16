package com.veer.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.veer.oauth.Dao.UserRepository;
import com.veer.oauth.model.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			User user = userRepo.findByUsername(username);
			
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoles());
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found with username "+username);
		}
		
	}

}
