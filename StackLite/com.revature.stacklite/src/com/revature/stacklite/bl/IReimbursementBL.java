package com.revature.stacklite.bl;

import java.util.List;
import com.revature.stacklite.models.Request;

public interface IReimbursementBL 
{
	void addRequest(Request request);
	List<Request> getRequests();
	Request getRequestById(int id) throws Exception;
	void deleteRequest(int id) throws Exception;
	void updateStatus(int id, String status);
}
