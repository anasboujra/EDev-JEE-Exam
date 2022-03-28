package com.eDev.controllers.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eDev.beans.Developper;
import com.eDev.services.DevelopperForm;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PARM_DELETE = "delete";
	private static final String ATT_LISTE = "liste";
	
	private static final String VUE_DASHBOARD = "/WEB-INF/view/dashboard.jsp";
	private static final String DASHBOARD = "dashboard";
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String delete = request.getParameter(PARM_DELETE);
		
		if(delete != null) {
			DevelopperForm form = new DevelopperForm();
			form.supprimer(request);

			response.sendRedirect(DASHBOARD);
			
		} else {
			DevelopperForm form = new DevelopperForm();
			List<Developper> messages = form.liste(request);
			request.setAttribute(ATT_LISTE, messages);

			this.getServletContext().getRequestDispatcher(VUE_DASHBOARD).forward(request, response);
		}
		
	}

	

}
