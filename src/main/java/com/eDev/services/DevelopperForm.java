package com.eDev.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.eDev.beans.Developper;
import com.eDev.beans.Programmeur;
import com.eDev.dao.DevelopperDao;

public class DevelopperForm {
	
	private static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";
	private static final String PARM_DELETE = "delete";

	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	
	
	public List<Developper> liste(HttpServletRequest request) {
		
		DevelopperDao developperDao = new DevelopperDao();
		
		HttpSession session = request.getSession();
		Programmeur programmeur = (Programmeur) session.getAttribute(ATT_SESSION_UTILISATEUR);
		
		List<Developper> liste = developperDao.findAllByColumn("programmeur.code", programmeur.getCode());
		
		return liste;
	}
	
	
	
	
	public void supprimer(HttpServletRequest request) {
		
		DevelopperDao developperDao = new DevelopperDao();
		
		Integer id = Integer.parseInt(request.getParameter(PARM_DELETE));
		Developper developper = developperDao.findByColumn("id", id);
		
		developperDao.delete(developper);
    }
	
	
	
	public String getResultat() {
		return resultat;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
}
