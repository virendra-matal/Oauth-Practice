package com.veer.oauth.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.veer.oauth.Dao.EmployeeRepository;
import com.veer.oauth.model.Employee;
@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
		
		String username = user.getUsername();
		Employee employee = empRepo.findByUsername(username);
				
		request.setAttribute("message", employee.getEmpName()+" Successfully logged out !!!");
		request.setAttribute("color","success");
		request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
		
		
	}

	
	
}
