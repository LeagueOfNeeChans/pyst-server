package com.trinary.vnjy.rest.ro.converters;

import java.util.HashMap;

import javax.ws.rs.core.UriInfo;

import com.trinary.ro.v2.converter.ROConverter;
import com.trinary.vnjy.rest.entities.Scene;
import com.trinary.vnjy.rest.resources.EngineResource;
import com.trinary.vnjy.rest.ro.SceneRO;

public class SceneConverter extends ROConverter<SceneRO, Scene> {
	private CommandConverter converter;

	public SceneConverter(UriInfo uriInfo) {
		super(uriInfo);
		converter = new CommandConverter(uriInfo);
	}

	@Override
	protected Scene _convertRO(SceneRO ro) {
		return null;
	}

	@Override
	protected SceneRO _convertEntity(Scene entity) {
		SceneRO ro = new SceneRO();
		
		ro.setInstanceId(entity.getInstanceId());
		ro.setCurrentScene(entity.getCurrentScene());
		ro.setCommands(converter.convertEntityList(entity.getCommands()));
		
		if (!"_wait".equals(entity.getNextScene())) {
			ro.setNextScene(entity.getNextScene());
			ro.setNextSceneHref(uriInfo
					.getBaseUriBuilder()
					.path(EngineResource.class)
					.path(EngineResource.class, "nextScene")
					.build(entity.getInstanceId()).toString());
		}
		
		ro.setChoices(new HashMap<String, String>());
		for (String choice : entity.getChoices()) {
			ro.getChoices().put(choice, uriInfo
					.getBaseUriBuilder()
					.path(EngineResource.class)
					.path(EngineResource.class, "chooseNextScene")
					.build(entity.getInstanceId(), choice).toString());
		}
		
		ro.setCurrentSceneHref(uriInfo
				.getBaseUriBuilder()
				.path(EngineResource.class)
				.path(EngineResource.class, "currentScene")
				.build(entity.getInstanceId()).toString());
		
		return ro;
	}

	@Override
	protected SceneRO _addLinks(SceneRO object) {
		// TODO Auto-generated method stub
		return null;
	}
}