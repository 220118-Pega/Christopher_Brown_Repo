package com.revature.stacklite.dl;

import java.util.List;

public interface DAO<T,K> 
{
	T findById(K id);
	List<T> findAll();
	void add(T newObject);
	void update(int id, String status);
	void delete(Integer id);
}