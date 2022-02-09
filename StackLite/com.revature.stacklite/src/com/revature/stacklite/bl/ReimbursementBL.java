package com.revature.stacklite.bl;

import java.util.List;
import com.revature.stacklite.dl.IRepository;
import com.revature.stacklite.models.Request;

public class ReimbursementBL implements IReimbursementBL
{
	private IRepository repo;
	public ReimbursementBL(IRepository repo)
	{
		this.repo = repo;
	}

	@Override
	public void addRequest(Request request) 
	{
		repo.addRequest(request);
	}

	@Override
	public List<Request> getRequests() 
	{
		return repo.getRequests();
	}

	@Override
	public Request getRequestById(int id) throws Exception 
	{
		return repo.getRequestById(id);
	}

	@Override
	public void deleteRequest(int id) throws Exception 
	{
		repo.deleteRequest(id);
	}

	@Override
	public void updateStatus(int id, String status) 
	{
		repo.updateRequest(id, status);
	}
}
