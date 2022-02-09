package com.revature.stacklite.controllers;

import com.revature.stacklite.bl.IReimbursementBL;
import com.revature.stacklite.models.Request;
import io.javalin.http.Handler;

public class RequestController implements IController
{
	private IReimbursementBL reimbursementBL;
	
	public RequestController(IReimbursementBL reimbursementBL)
	{
		this.reimbursementBL = reimbursementBL;
	}
	
	@Override
	public Handler getAll() 
	{
		return ctx -> 
		{
			ctx.jsonStream(reimbursementBL.getRequests());
		};
	}

	@Override
	public Handler getById() 
	{
		return ctx ->
		{
			String id = ctx.pathParam("request_id");
			int actualID = Integer.parseInt(id);
			try 
			{
				ctx.jsonStream(reimbursementBL.getRequestById(actualID));
			}
			catch (NullPointerException ex)
			{
				ctx.res.setStatus(204);
			}
		};
	}

	@Override
	public Handler add() 
	{
		return ctx -> 
		{
			Request newRequest = ctx.bodyStreamAsClass(Request.class);
			try 
			{
				reimbursementBL.addRequest(newRequest);
				ctx.status(201);
			}
			catch (Exception e)
			{
				ctx.status(400);
			}
		};
	}

	@Override
	public Handler update() 
	{
		return ctx ->
		{
			String id = ctx.pathParam("request_id");
			String status = ctx.pathParam("status");
			int actualID = Integer.parseInt(id);
			try 
			{
				reimbursementBL.updateStatus(actualID, status);
				ctx.status(201);
			}
			catch (NullPointerException ex)
			{
				ctx.res.setStatus(204);
			}
		};
	}
	
	@Override
	public Handler delete() 
	{
		return ctx ->
		{
			String id = ctx.pathParam("request_id");
			int actualID = Integer.parseInt(id);
			try 
			{
				reimbursementBL.deleteRequest(actualID);
				ctx.status(201);
			}
			catch (NullPointerException ex)
			{
				ctx.res.setStatus(204);
			}
		};
	}
}