package com.revature.stacklite.dl;

import java.util.List;
import com.revature.stacklite.models.Request;

public class DBrepository implements IRepository
{
	private DAO<Request, Integer> requestDAO;
	
	public DBrepository(DAO<Request, Integer> requestDAO)
	{
		this.requestDAO = requestDAO;
	}
	
	@Override
	public void addRequest(Request newRequest) 
	{
		requestDAO.add(newRequest);
	}

	@Override
	public List<Request> getRequests() 
	{
		return requestDAO.findAll();
	}

	@Override
	public Request getRequestById(int id) throws Exception 
	{
		Request requestWanted = requestDAO.findById(id);
		return requestWanted;
	}

	@Override
	public void updateRequest(int id, String status) 
	{
		requestDAO.update(id, status);
	}

	@Override
	public void deleteRequest(int id) 
	{
		requestDAO.delete(id);
	}
}