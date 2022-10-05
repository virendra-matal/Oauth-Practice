package com.veer.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.veer.oauth.Dao.EmployeeRepository;
import com.veer.oauth.model.Employee;


public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			System.out.println("username at userdetailsService: "+username);
			Employee employee = empRepo.findByUsername(username);
			if (employee == null) {
				throw new UsernameNotFoundException("User not found with username "+username);
			}else {
			UserDetailsImpl userDetailsImpl = new UserDetailsImpl(employee);
			return userDetailsImpl;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found with username "+username);
		}
		
	}

}
