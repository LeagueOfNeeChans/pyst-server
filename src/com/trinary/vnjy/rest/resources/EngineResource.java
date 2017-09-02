package com.trinary.vnjy.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.trinary.vnjy.rest.entities.Scene;
import com.trinary.vnjy.rest.ro.EngineInstanceRO;
import com.trinary.vnjy.rest.ro.converters.SceneConverter;
import com.trinary.vnjy.rest.services.EngineService;
import com.trinary.vnjy.rest.services.TestEngineService;

@Path("/engine")
@Produces(MediaType.APPLICATION_JSON)
public class EngineResource {
	EngineService engineService = new TestEngineService();
	
	@Context
	UriInfo uriInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEngineInstance(
			EngineInstanceRO engineInstance) {
		String id = engineService.createInstance(engineInstance.getGameName());
		engineInstance.setId(id);
		
		return Response.ok(engineInstance).build();
	}
	
	@Path("/{instance-id}/shit")
	@GET
	public Response getGameResources(
			@PathParam("instance-id") String instanceId) throws Exception {
		return Response.ok(engineService.getShit(instanceId)).build();
	}
	
	@Path("/{instance-id}/scene")
	@GET
	public Response currentScene(
			@PathParam("instance-id") String instanceId) throws Exception {
		SceneConverter converter = new SceneConverter(uriInfo);
		
		Scene scene = engineService.getCurrentScene(instanceId);
		
		return Response.ok(converter.convertEntity(scene)).build();
	}
	
	@Path("/{instance-id}/scene/next")
	@GET
	public Response nextScene(
			@PathParam("instance-id") String instanceId) throws Exception {
		SceneConverter converter = new SceneConverter(uriInfo);
		
		Scene scene = engineService.getNextScene(instanceId);
		
		return Response.ok(converter.convertEntity(scene)).build();
	}
	
	@Path("/{instance-id}/scene/{choice}")
	@GET
	public Response chooseNextScene(
			@PathParam("instance-id") String instanceId,
			@PathParam("choice") String choice) throws Exception {
		SceneConverter converter = new SceneConverter(uriInfo);
		
		Scene scene = engineService.answerPrompt(instanceId, choice);
		
		return Response.ok(converter.convertEntity(scene)).build();
	}
}