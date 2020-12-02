package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Vehicle;
public interface VehicleDao {
	long saveVehicle(Vehicle vehicle);
	 
    void updateVehicle(Vehicle vehicle);
 
    void deleteVehicle(long id);
 
    Vehicle findVehicleById(long id);
    
     List<Vehicle> findVehiclesByModello(String modello);
    
     List<Vehicle> findVehiclesByCasa(String casa);
    
     List<Vehicle> findVehiclesByAnno(String anno);
     
    List<Vehicle> findAllVehicles();
}
