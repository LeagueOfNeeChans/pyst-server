package com.trinary.vnjy.rest.ro;

import com.trinary.ro.v2.RepresentationObject;

public class EngineInstanceRO extends RepresentationObject {
	private String id;
	private String gameName;
	private String playerId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
}