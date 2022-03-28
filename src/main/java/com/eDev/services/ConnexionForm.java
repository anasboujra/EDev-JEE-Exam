package com.eDev.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.eDev.beans.Programmeur;
import com.eDev.dao.ProgrammeurDao;

public class ConnexionForm {
	
	private final static String CHAMP_LOGIN = "login";
	private final static String CHAMP_MOTPASSE = "motPasse";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat = null;
	
	
	public Programmeur connexionProgrammeur(HttpServletRequest request) {
		
		Programmeur programmeur = new Programmeur();
		String login = request.getParameter(CHAMP_LOGIN);
		String motPasse = request.getParameter(CHAMP_MOTPASSE);
		
		try {
			validationLogin(login);
		}catch(Exception e){
			erreurs.put(CHAMP_LOGIN, e.getMessage());
		}
		
		try {
			validationMotPasse(motPasse);
		}catch(Exception e){
			erreurs.put(CHAMP_MOTPASSE, e.getMessage());
		}
		
		
		if(erreurs.isEmpty()) {
			ProgrammeurDao programmeurDao = new ProgrammeurDao();
			programmeur = programmeurDao.verify(login, motPasse);
			if(programmeur != null) {
				return programmeur;
			}
		}
		
		resultat = "Echec de la connexion";
		
		programmeur = new Programmeur();
		programmeur.setLogin(login);
		programmeur.setMotPasse(motPasse);
		
		
		return programmeur;
	}
	
	
	private void validationLogin(String login) throws Exception{
		if(login==null || login.length()==0) {
			throw new Exception("Merci de saisir un login");
		}
		else if(!login.matches(".{2,30}")) {
			throw new Exception("Merci de saisir un login de 2 caracters au minimum");
		}
	}

	private void validationMotPasse(String motPasse) throws Exception {
		if(motPasse==null || motPasse.length()==0) {
			throw new Exception("Merci de saisir un mot de passe");
		}
		else if(!motPasse.matches(".{2,30}")) {
			throw new Exception("Merci de saisir un mot de passe de 2 caracters au minimum");
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
}
