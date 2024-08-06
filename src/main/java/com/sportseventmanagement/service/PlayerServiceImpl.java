package com.sportseventmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sportseventmanagement.dao.PlayerDao;
import com.sportseventmanagement.entities.Players;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	//List<Players> list;
	
	public PlayerServiceImpl() {
		
//		list = new ArrayList<>();
//		list.add(new Players(1001, "Rajan", 23, "8779298256", "2668rajan@gmail.com", "male", "Cricket"));
//		list.add(new Players(1002, "Sidd", 23, "8617792869", "sidd86177@gmail.com", "male", "Cricket"));
//		list.add(new Players(1003, "Adnan", 22, "8617725869", "Adnan69@gmail.com", "male", "Cricket"));
	}

	@Override
	public List<Players> getPlayers() {
		//return list;
		return playerDao.findAll();
	}

	@Override
	public Players getPlayer(Long parseLong) {

//		Players p = null;
//		for (Players player : list) {
//			if (player.getPlayerId() == parseLong) {
//				p = player;
//				break;
//			}
//		}
//		return p;
		Optional<Players> id = playerDao.findById(parseLong);
		return id.get();
	}

	@Override
	public Players addPlayer(Players player) {
		//list.add(player);
		
		//System.out.println(player + "added successfully");
//		String password = player.getPassword();
//		String hashPassword = hashPassword(password);
//		player.setPassword(hashPassword);
		playerDao.save(player);
		return player;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deletePlayer(Long playerId) {
//		Players p = null;
//		for (Players player : list) {
//			if (player.getPlayerId() == playerId) {
//				p = player;
//				break;
//			}
//		}

		//list=this.list.stream().filter(e->e.getPlayerId()!=playerId).collect(Collectors.toList());

		Players entity = playerDao.getOne(playerId);
		playerDao.delete(entity);
		System.out.println(entity + "removed successfully");
	}

	public static String hashPassword(String password_plaintext) {
		int workload = 12;
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
		return(hashed_password);
	}

	@Override
	public boolean playerExists(String playerName) {

		return playerDao.existsByplayerName(playerName);
	}

	@Override
	public boolean playerExists(Long playerId) {
		return playerDao.existsById(playerId);
	}

	

	
	
}
