package com.eDev.controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eDev.beans.Programmeur;
import com.eDev.services.ConnexionForm;


@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_FORM = "form";
	private static final String ATT_PROGRAMMEUR = "programmeur";
	private static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";
	
	private static final String VUE_CONNEXION = "/WEB-INF/view/connexion.jsp";
	private static final String VUE_DASHBOARD = "dashboard";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm form = new ConnexionForm();
		Programmeur programmeur = form.connexionProgrammeur(request);
		
		HttpSession session = request.getSession();
		
		if(form.getErreurs().isEmpty() && form.getResultat()==null) {
			session.setAttribute(ATT_SESSION_UTILISATEUR, programmeur);
			response.sendRedirect(VUE_DASHBOARD);
		}
		else {
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_PROGRAMMEUR, programmeur);
			session.setAttribute(ATT_SESSION_UTILISATEUR, null);
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
		
		
	}


}
