package com.veer.oauth.config.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.veer.oauth.Dao.EmployeeRepository;
import com.veer.oauth.model.Employee;
import com.veer.oauth.model.Provider;

@Component
public class Oauth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		CustomeOauth2USer oauthUser = (CustomeOauth2USer) authentication.getPrincipal();

		System.out.println("Client Name at handler: " + oauthUser.getClientName());
		System.out.println("username at handler: " + oauthUser);
		System.out.println("Name : " + oauthUser.getName());
		System.out.println("Email : " + oauthUser.getEmail());
		
		Employee ExistUser = empRepo.findByUsername(oauthUser.getEmail());
		
		if(ExistUser == null) {
			Employee employee = new Employee();
			employee.setEmpName(oauthUser.getName());
			employee.setUsername(oauthUser.getEmail());
			employee.setAuthProvider(oauthUser.getClientName().toUpperCase());
			employee.setRole("ROLE_USER");
			
			String email=oauthUser.getEmail();
			String[] pass = email.split("[\\s@]+");
			System.out.println("SubString of Email after removing @gmail.com is:"+pass[0]);
			
			employee.setPassword(passwordEncoder.encode(pass[0]));
			empRepo.save(employee);
		}
		
		System.out.println("EMployee details at OnSuccessHandler : "+ ExistUser);

		String requestUrl = request.getContextPath();

		

		response.sendRedirect(requestUrl+"/dashboard/"+oauthUser.getEmail());
	}

}
