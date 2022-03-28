package com.eDev.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class ConnexionFilter implements Filter {
	
	private static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";

	private static final String VUE_CONNEXION = "connexion";

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session =  request.getSession();
		
		if(session.getAttribute(ATT_SESSION_UTILISATEUR) == null) {
			request.getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}
}
