package com.rentalcar.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rentalcar.webapp.dao.VehicleDao;
import com.rentalcar.webapp.entities.Vehicle;
import com.rentalcar.webapp.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	@Override
	public long insVehicle(Vehicle vehicle) {
		vehicleDao.saveVehicle(vehicle);
		return 0;
	}

	@Override
	public void elVehicleId(long id) {
		vehicleDao.deleteVehicle(id);
		
	}

	@Override
	public void aggVehicle(Vehicle vehicle) {
		vehicleDao.updateVehicle(vehicle);
		
	}

	@Override
	public Vehicle cercaVehicleId(long id) {
		return vehicleDao.findVehicleById(id);
	}

	@Override
	public List<Vehicle> trovaTutti() {
		return vehicleDao.findAllVehicles();
	}
	@Override
	public List<Vehicle> trovaPerModello(String modello) {
		return vehicleDao.findVehiclesByModello(modello);
	}
	@Override
	public List<Vehicle> trovaPerCasa(String casa) {
		return vehicleDao.findVehiclesByCasa(casa);
	}
	@Override
	public List<Vehicle> trovaPerAnno(String anno) {
		return vehicleDao.findVehiclesByCasa(anno);
	}
	
	@Override
	public void elVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}
   
}
