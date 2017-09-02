package com.trinary.vnjy.rest.ro;

import java.util.List;
import java.util.Map;

public class SceneRO {
	private String instanceId;
	private String nextScene;
	private String nextSceneHref;
	private String currentScene;
	private String currentSceneHref;
	private Map<String, String> choices;
	private List<CommandRO> commands;
	
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getNextScene() {
		return nextScene;
	}
	public void setNextScene(String nextScene) {
		this.nextScene = nextScene;
	}
	public String getCurrentScene() {
		return currentScene;
	}
	public void setCurrentScene(String currentScene) {
		this.currentScene = currentScene;
	}
	public String getNextSceneHref() {
		return nextSceneHref;
	}
	public void setNextSceneHref(String nextSceneHref) {
		this.nextSceneHref = nextSceneHref;
	}
	public String getCurrentSceneHref() {
		return currentSceneHref;
	}
	public void setCurrentSceneHref(String currentSceneHref) {
		this.currentSceneHref = currentSceneHref;
	}
	public Map<String, String> getChoices() {
		return choices;
	}
	public void setChoices(Map<String, String> choices) {
		this.choices = choices;
	}
	public List<CommandRO> getCommands() {
		return commands;
	}
	public void setCommands(List<CommandRO> commands) {
		this.commands = commands;
	}
}