package com.sportseventmanagement.service;

import java.util.List;

import com.sportseventmanagement.entities.Players;

public interface PlayerService {

	public List<Players> getPlayers();

	public Players getPlayer(Long parseLong);

	public Players addPlayer(Players player);

	public void deletePlayer(Long parseLong);

	public boolean playerExists(String playerName);

	public boolean playerExists(Long playerId);

	//public boolean playerExist(Long playerId);

	


}
