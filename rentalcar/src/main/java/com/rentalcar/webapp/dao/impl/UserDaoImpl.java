package com.rentalcar.webapp.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.dao.AbstractDao;
import com.rentalcar.webapp.dao.UserDao;
import com.rentalcar.webapp.entities.Reservation;
import com.rentalcar.webapp.entities.User;

@Repository  //stiamo dicendo che farà parte dello strato di persistenza
public class UserDaoImpl extends AbstractDao<User,Long>
implements UserDao{

	@Override
	public long  saveUser(User user) {
		// TODO Auto-generated method stub
		super.Inserisci(user);
		
		return 0;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		super.Aggiorna(user);
	}

	@Override
	public void deleteUserById(long id) {
		super.EliminaById(id);
		
	}
	@Override
	public void deleteUser(User user) {
		super.Elimina(user);
		
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return super.SelById(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return super.SelTutti();
	}
    
	
	public List<User> findUsersByNome(String nome)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<User> query  = builder.createQuery(User.class);
    	
    	Root<User> recordSet = query.from(User.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("nome"),nome));
    	
    	List<User> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
	public List<User> findUsersbyCognome(String cognome)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<User> query  = builder.createQuery(User.class);
    	
    	Root<User> recordSet = query.from(User.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("cognome"),cognome));
    	
    	List<User> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
	public List<User> findUsersByEmail(String email)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<User> query  = builder.createQuery(User.class);
    	
    	Root<User> recordSet = query.from(User.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("email"),email));
    	
    	List<User> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
}
