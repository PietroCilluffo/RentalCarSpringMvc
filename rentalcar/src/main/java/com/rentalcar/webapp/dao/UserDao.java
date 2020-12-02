package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.User;

public interface UserDao {
    long saveUser(User User);
    
    //int saveUser(SuperUser User);
 
    void updateUser(User User);
 
    void deleteUserById(long id);
    
    void deleteUser(User User);
 
    User findUserById(long  id);
    
   // User findUserByEmail(String email);
    
   // SuperUser findSuperUserById(int id);
    
  //  SuperUser findSuperUserByEmail(String email);
 
    List<User> findAllUsers();
    
    List<User> findUsersByNome(String nome);
    
    List<User> findUsersbyCognome(String cognome);
   
    List<User> findUsersByEmail(String email);
    
}