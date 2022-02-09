package com.revature.stacklite.dl;

import java.util.List;
import com.revature.stacklite.models.Request;

public interface IRepository 
{
	void addRequest(Request newRequest);
	List<Request> getRequests();
	Request getRequestById(int id) throws Exception;
	void updateRequest(int id, String status);
	void deleteRequest(int id);
}
