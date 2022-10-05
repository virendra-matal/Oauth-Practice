package com.veer.oauth.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
		
		System.out.println("username at handler: "+principal);
		System.out.println("role : "+principal.hasRole());
		System.out.println("role : "+principal.hasRole().equalsIgnoreCase("ROLE_USER"));
		
		String requestUrl=request.getContextPath();
		
		
			if(principal.hasRole().equalsIgnoreCase("ROLE_USER")) {
				requestUrl += "/dashboard";
			}else {
				requestUrl += "/admin";
			}
		
		
		response.sendRedirect(requestUrl);
	}
	
	

}
