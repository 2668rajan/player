package com.sportseventmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportseventmanagement.entities.Players;
import com.sportseventmanagement.exception.AuthenticationException;
import com.sportseventmanagement.exception.PlayerAlreadyExistsException;
import com.sportseventmanagement.exception.PlayerNotFoundException;
import com.sportseventmanagement.feign.Iproxy;
import com.sportseventmanagement.service.PlayerService;


@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;

	@Autowired
	private Iproxy iproxy;
	
	Logger log = LoggerFactory.getLogger(PlayerController.class);
	
	@GetMapping("/home")
	public String home() {
		return "Welcome page";
	}
	
	@GetMapping("/players")
	public List<Players> getPlayers(@RequestHeader(value = "Authorization", required = true) String token1) throws PlayerNotFoundException, AuthenticationException{
		if(iproxy.getvalidation(token1)) {
			List<Players> players = playerService.getPlayers();
			if(players.isEmpty()) {
				throw new PlayerNotFoundException("Players Not Found");
			}
			log.info("List of all players: "+players);
			return players;
		}else {
			 throw new AuthenticationException("You are not authorized.");
		}
	}
	
	//get the player with id
		//@SuppressWarnings("null")
		@GetMapping("/players/{playerId}")
		public Players getPlayer(@PathVariable Long playerId, @RequestHeader(value = "Authorization", required = true) String token1) throws PlayerNotFoundException, AuthenticationException {
			if(iproxy.getvalidation(token1)) {
			
				if(playerService.playerExists(playerId)) {
					log.info("Player with id "+playerId+" fetched");
					return this.playerService.getPlayer(playerId);
				}else {
					throw new PlayerNotFoundException("Player not found");
				}
			}else {
				throw new AuthenticationException("You are not authorized");
			}
		}
		
	//add a player
		@PostMapping("/players")
		public ResponseEntity<String> addPlayer(@RequestBody Players player, @RequestHeader(value = "Authorization", required = true) String token1) throws PlayerAlreadyExistsException, AuthenticationException{
			if(iproxy.getvalidation(token1)) {
				if(playerService.playerExists(player.getPlayerName())){
					throw new PlayerAlreadyExistsException("Player Already Exists");
				}
					playerService.addPlayer(player);
				
					log.info("Player with player Id : "+ player.getId() + " successfully created");
				
					return new ResponseEntity<>("Player added Successfully!",HttpStatus.CREATED);
			}else {
				throw new AuthenticationException("You are not authoriized");
			}
		}
		
		//Delete a player
		@DeleteMapping("/players/{playerId}")
		public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Long playerId,  @RequestHeader(value = "Authorization", required = true) String token1) throws AuthenticationException, PlayerNotFoundException {
			if(iproxy.getvalidation(token1)) {
				if(playerService.playerExists(playerId)) {
					try {
						this.playerService.deletePlayer(playerId);
						return new ResponseEntity<>(HttpStatus.OK);
					}
					catch(Exception e){
						log.info("player with id: " + playerId + " not found");
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}else {
					throw new PlayerNotFoundException("Player not found");
				}
			}else{
				throw new AuthenticationException("You are not authorized");
			}
		}
}
