package com.revature.stacklite.controllers;

import io.javalin.http.Handler;

public interface IController 
{
	Handler getAll();
	Handler getById();
	Handler add();
	Handler update();
	Handler delete();
}
