package com.vigo.webpersist.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vigo.webpersist.model.Client;
import com.vigo.webpersist.service.ClientService;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {
	
	
	
	
	@GET
	@Path("/clients")
	public List<Client> getClient(){
		
		return new ArrayList<Client>(ClientService.getClients());
	}
	
	@GET
	@Path("/client/{id}")
	public Client getClient(@PathParam("id") int id) {
		
		return ClientService.getClient(id);
	}
	
	
	@POST
	@Path("/createclient")
	public Client createClient(Client client) {
		
		return ClientService.createClient(client);
	}

	
	@PUT
	@Path("/updateclient/{id}")
	public Client  updateClient(@PathParam("id") int id,Client client) {
		
		return ClientService.updateClient(id,client);
	}
	
	@DELETE
	@Path("/deleteclient/{id}")
	public Response deleteClient(@PathParam("id") int id) {
		
		ClientService.deleteClient(id);
		return Response.noContent().build();
		
	}
}
