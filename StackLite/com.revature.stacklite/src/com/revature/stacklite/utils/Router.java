package com.revature.stacklite.utils;

import com.revature.stacklite.controllers.IController;
import io.javalin.Javalin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

public class Router 
{
	private Javalin app;
	private IController requestController;

	public Router(Javalin app, IController requestController)
	{
		this.app = app;
		this.requestController = requestController;
	}
	
	/*
	 * Javalin has the concept of a Handler. A Handler is void and takes a Context 
	 * (which wraps HttpServletRequest and HttpServletResponse),
	 *  and you operate on both the request and response through this Context.
	 *  */
	
	public void setUpEndPoints() 
	{
		//get all
		app.get("/Requests", OpenApiBuilder.documented(DocumentationFactory.getDoc("getRequests"), requestController.getAll()));
		
		//get one by id
		app.get("/Requests/{request_id}",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getRequestById"), requestController.getById()));
		
		//get all requests of status
		//app.get("/Requests/{status}", null);
		
		//create a request
		app.post("/Requests",  OpenApiBuilder.documented(DocumentationFactory.getDoc("addRequest"), requestController.add()));
		
		//delete a request
		app.delete("/Requests/{request_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("deleteRequest"), requestController.delete()));
		
		//update a request
		app.put("/Requests/{request_id}/Status/{status}", OpenApiBuilder.documented(DocumentationFactory.getDoc("updateStatus"), requestController.delete()));
	}
}
