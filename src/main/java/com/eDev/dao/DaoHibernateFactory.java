package com.eDev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.eDev.util.HibernateUtil;

public class DaoHibernateFactory<T> implements DaoInterface<T> {
	
	protected Session currentSession;
	protected Transaction currentTransaction;
    protected Class<T> persistentClass;
	
    
	public DaoHibernateFactory(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	
	@Override
    public void delete(T entity) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    	currentSession.delete(entity);
        currentTransaction.commit();
        currentSession.close();
    }
 
	
	
	@SuppressWarnings("unchecked")
	@Override
    public T findByColumn(String column, Integer condition) {
    	currentSession = HibernateUtil.getSessionFactory().openSession();
        T entity = (T) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).uniqueResult();
        currentSession.close();
        return entity; 
    }
 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByColumn(String column, Integer condition) {
		currentSession = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = (List<T>) currentSession.createQuery("from " + persistentClass.getSimpleName() + " e where e."
        		+ column + " = :condition").setParameter("condition", condition).getResultList();
        currentSession.close();
        return entities;
	}
}
