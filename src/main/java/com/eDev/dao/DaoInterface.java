package com.eDev.dao;

import java.util.List;

public interface DaoInterface<T> {
	
	public void delete(T element);
	
	public T findByColumn(String column, Integer condition);
	
	public List<T> findAllByColumn(String column, Integer condition);
	
}
