package com.rentalcar.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.service.UserService;


// a questo livello applicherò le business logic
@Service
@Transactional
public class UserServiceImpl implements UserService {

	//code injection dello strato di persistenza
	@Autowired
	private UserDao userDao;
	
	@Override
	public long insUser(User user) {
		
		return userDao.saveUser(user);
	}

	@Override
	public void elUserId(long id) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(id);
	}
    
	@Override
	public void elUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}
	@Override
	public void aggUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public User cercaUserId(long id) {
		
		return userDao.findUserById(id);
	}

	@Override
	public List<User> trovaTutti() {
		// TODO Auto-generated method stub
		return userDao.findAllUsers();
	}
	@Override
	public List<User> trovaPerNome(String nome) {
		// TODO Auto-generated method stub
		return userDao.findUsersByNome(nome);
	}
	@Override
	public List<User> trovaPerCognome(String cognome) {
		// TODO Auto-generated method stub
		return userDao.findUsersbyCognome(cognome);
	}
	@Override
	public List<User> trovaPerEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUsersByEmail(email);
	}

}
