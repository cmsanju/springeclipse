package com.test.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloService 
{
	
	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloPlainText()
	{
		return "hi this is plain text service";
	}
	@GET
	@Path("/html/{name}")
	@Produces(MediaType.TEXT_HTML)
	public String helloTextHTML(@PathParam("name") String name)
	{
		return "<html><body> <h2> hello this is HTML RESPONSE   "+name+"</h2></body></html>";
	}
	
	@POST  
    @Path("/add")  
    public Response addUser(  
        @FormParam("id") int id,  
        @FormParam("name") String name,  
        @FormParam("price") float price) {  
   
        return Response.status(200)  
            .entity(" Product added successfuly!<br> Id: "+id+"<br> Name: " + name+"<br> Price: "+price)  
            .build();  
    }  
}
//http://localhost:8080/restapitest/rest/hello/text
