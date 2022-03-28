package com.eDev.dao;

import com.eDev.beans.Programmeur;
import com.eDev.util.HibernateUtil;

public class ProgrammeurDao extends DaoHibernateFactory<Programmeur> {

	public ProgrammeurDao() {
		super(Programmeur.class);
	}
	
	public Programmeur verify(String login, String motPasse) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
    	Programmeur programmeur = (Programmeur) currentSession.createQuery("from Programmeur c where c.login = :login").setParameter("login", login).uniqueResult();
    	currentSession.close();
    	if(programmeur != null && motPasse.equals(programmeur.getMotPasse())) {
    			return programmeur;
    	}
      	return null;
	}

}
