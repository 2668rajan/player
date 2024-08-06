package com.sportseventmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "players")
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotNull(message = "Player name cannot be null")
	private String playerName;
	//@Size(min=16,max=45, message= "Enter valid age")
	private int age;
	//@Size(min=10,max=10,message="Enter valid number")
	private String contactNo;
	//@NotNull(message = "Player name cannot be null")
	private String email;
	//@NotNull(message = "Player name cannot be null")
	private String gender;
	//@NotNull(message = "Player name cannot be null")
	private String sportsName;
	
//	@NotNull(message = "Player name cannot be null")
//	private String username;
//	@NotNull(message = "Player name cannot be null")
//	private String password;

	public Players(Long playerId, String playerName, int age, String contactNo, String email, String gender,
			String sportsName) {
		super();
		this.id = playerId;
		this.playerName = playerName;
		this.age = age;
		this.contactNo = contactNo;
		this.email = email;
		this.gender = gender;
		this.sportsName = sportsName;
//		this.username = username;
//		this.password = password;
	}

	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long playerId) {
		this.id = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	@Override
	public String toString() {
		return "Players [id=" + id + ", playerName=" + playerName + ", age=" + age + ", contactNo=" + contactNo
				+ ", email=" + email + ", gender=" + gender + ", sportsName=" + sportsName + "]";
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	
	
	

}
