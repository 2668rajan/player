package com.sportseventmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventmanagement.entities.Players;

public interface PlayerDao extends JpaRepository<Players, Long> {

	boolean existsByplayerName(String playerName);



	

}
