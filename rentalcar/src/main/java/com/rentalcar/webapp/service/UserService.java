package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.User;

public interface UserService {
	
	long insUser(User user);
	void elUserId(long id);
	void aggUser(User user);
	User cercaUserId(long id);
	List<User> trovaTutti();
	List<User> trovaPerNome(String nome);
	List<User> trovaPerCognome(String cognome);
	List<User> trovaPerEmail(String email);
	void elUser(User user);
	
	
}
