package com.revature.stacklite.reimbursements;

import com.revature.stacklite.bl.ReimbursementBL;
import com.revature.stacklite.controllers.IController;
import com.revature.stacklite.controllers.RequestController;
import com.revature.stacklite.dl.DBrepository;
import com.revature.stacklite.dl.RequestDAO;
import com.revature.stacklite.utils.Router;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

public class RESTDriver 
{
	public static void main (String[] args)
	{
		IController requestController = new RequestController(new ReimbursementBL(new DBrepository(new RequestDAO())));
		Javalin app = Javalin.create(config -> 
		{
			config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
		}).start(7000);

		Router router = new Router(app, requestController);
		router.setUpEndPoints();
	}
	

	private static OpenApiOptions getOpenApiOptions()
	{
		// Configuring swagger
		// Use swagger for documentation and testing the API
		Info applicationInfo = new Info().version("1.0").description("Stacklite REST");
		return new OpenApiOptions(applicationInfo).path("/swagger-docs").swagger(new SwaggerOptions("/swagger").title("StackLite API Docs"));
	}
}
