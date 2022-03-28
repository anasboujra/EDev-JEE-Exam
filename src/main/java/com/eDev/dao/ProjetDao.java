package com.eDev.dao;

import com.eDev.beans.Projet;

public class ProjetDao extends DaoHibernateFactory<Projet>{

	public ProjetDao() {
		super(Projet.class);
	}

}
