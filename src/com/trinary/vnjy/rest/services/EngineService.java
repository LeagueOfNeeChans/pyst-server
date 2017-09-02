package com.trinary.vnjy.rest.services;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.trinary.vnjy.rest.entities.Scene;

@ApplicationScoped
public interface EngineService {
	String createInstance(String game);
	Map<String, Object> getShit(String instanceId) throws Exception;
	Scene getNextScene(String instanceId) throws Exception;
	Scene answerPrompt(String instanceId, String choice) throws Exception;
	Scene getCurrentScene(String instanceId) throws Exception;
}