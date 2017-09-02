package com.trinary.vnjy.rest.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.inject.Alternative;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trinary.vnjy.rest.entities.Scene;
import com.trinary.vnjy.se.Command;
import com.trinary.vnjy.se.GameState;
import com.trinary.vnjy.se.ScriptEngine;

@Alternative
public class TestEngineService implements EngineService {
	private static Map<String, GameState> instances = new HashMap<>();
	private static ObjectMapper mapper = new ObjectMapper();
	private static TypeReference<Map<String, Object>> t = new TypeReference<Map<String, Object>>() {};
	
	@Override
	public String createInstance(String game) {
		String uuid = UUID.randomUUID().toString();
		instances.put(uuid, GameState.create(game));
		
		return uuid;
	}
	
	@Override
	public Map<String, Object> getShit(String instanceId) throws Exception {
		GameState gameState = instances.get(instanceId);
		
		if (gameState == null) {
			throw new Exception("No engine instance found for that id");
		}
		
		// Find game's shit
		String shitFile = "/var/games/" + gameState.getGame() + ".shit";
		File shitFileObject = new File(shitFile);
		if (!shitFileObject.exists()) {
			throw new Exception("Cannot find shit for game: "+ gameState.getGame());
		}
		
		// Load in the shit heap
		try {
			Map<String, Object> shitHeap = mapper.readValue(shitFileObject, t);
			shitHeap.put("script", null);
			return shitHeap;
		} catch (IOException e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public Scene getCurrentScene(String instanceId) throws Exception {
		GameState state = instances.get(instanceId);
		
		if (state == null) {
			throw new Exception("No engine instance found for that id");
		}
		
		ScriptEngine engine = ScriptEngine.create(state);
		
		if (!engine.currentScene()) {
			return null;
		}
		
		Scene scene = new Scene();
		List<Command> commands = engine.flushCommands();
		
		scene.setInstanceId(instanceId);
		scene.setCurrentScene(state.getCurrentScene());
		scene.setNextScene(state.getNextScene());
		scene.setCommands(commands);
		scene.setChoices(state.getValidTransitions());
		
		return scene;
	}
	
	@Override
	public Scene getNextScene(String instanceId) throws Exception {
		GameState state = instances.get(instanceId);
		
		if (state == null) {
			throw new Exception("No engine instance found for that id");
		}
		
		ScriptEngine engine = ScriptEngine.create(state);
		
		if (!state.isInitialized()) {
			if (!engine.currentScene()) {
				return null;
			}
			state.setInitialized(true);
		}
		
		if (!engine.nextScene()) {
			return null;
		}
		
		Scene scene = new Scene();
		List<Command> commands = engine.flushCommands();
		
		scene.setInstanceId(instanceId);
		scene.setCurrentScene(state.getCurrentScene());
		scene.setNextScene(state.getNextScene());
		scene.setCommands(commands);
		scene.setChoices(state.getValidTransitions());
		
		return scene;
	}
	
	@Override
	public Scene answerPrompt(String instanceId, String choice) throws Exception {
		GameState state = instances.get(instanceId);
		
		if (state == null) {
			throw new Exception("No engine instance found for that id");
		}
		
		ScriptEngine engine = ScriptEngine.create(state);
		
		engine.choose(choice);
		if (!engine.nextScene()) {
			return null;
		}
		
		Scene scene = new Scene();
		List<Command> commands = engine.flushCommands();
		
		scene.setInstanceId(instanceId);
		scene.setCurrentScene(state.getCurrentScene());
		scene.setNextScene(state.getNextScene());
		scene.setCommands(commands);
		scene.setChoices(state.getValidTransitions());
		
		return scene;
	}
}