package com.trinary.vnjy.rest.entities;

import java.util.List;
import java.util.Set;

import com.trinary.vnjy.se.Command;

public class Scene {
	private String instanceId;
	private String nextScene;
	private String currentScene;
	private Set<String> choices;
	private List<Command> commands;
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
	public Set<String> getChoices() {
		return choices;
	}
	public void setChoices(Set<String> choices) {
		this.choices = choices;
	}
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
}