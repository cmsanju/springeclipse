package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloService {
	
	@GET
	@Path("plain")
	@Produces(MediaType.TEXT_PLAIN)
	public String plainText()
	{
		return "This is simple plain text response";
	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String htmlText()
	{
		return "<html><body><h1>This is simple html text response</h1></body></html>";
	}

}
