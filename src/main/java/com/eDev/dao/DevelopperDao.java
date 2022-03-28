package com.eDev.dao;

import com.eDev.beans.Developper;

public class DevelopperDao  extends DaoHibernateFactory<Developper>{

	public DevelopperDao() {
		super(Developper.class);
	}

}
