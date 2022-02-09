package com.revature.stacklite.utils;

import com.revature.stacklite.models.Request;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;

public class DocumentationFactory 
{
	public static OpenApiDocumentation getDoc(String endPoint)
	{
		switch (endPoint)
		{
		case "getRequests":
			return OpenApiBuilder.document().operation(op -> {op.addTagsItem("Request");}).jsonArray("200",  Request.class);
		case "getRequestById" :
			return OpenApiBuilder.document().operation(op -> {op.addTagsItem("Request");}).json("200",  Request.class);
		case "addRequest":
			return OpenApiBuilder.document().operation(op -> {op.addTagsItem("Request");}).body(Request.class).result("201");
		case "deleteRequest":
			return OpenApiBuilder.document().operation(op -> {op.addTagsItem("Request");}).json("200",  Request.class);
		case "updateStatus":
			return OpenApiBuilder.document().operation(op -> {op.addTagsItem("Request");}).json("200",  Request.class);
			default:
				return null;			
		}
	}
}
