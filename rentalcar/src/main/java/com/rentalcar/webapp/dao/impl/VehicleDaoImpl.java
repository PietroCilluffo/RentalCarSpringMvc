package com.rentalcar.webapp.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.dao.AbstractDao;
import com.rentalcar.webapp.dao.VehicleDao;
import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.entities.Vehicle;
@Repository 
public class VehicleDaoImpl extends AbstractDao<Vehicle,Long>
implements VehicleDao{

	@Override
	public long saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		super.Inserisci(vehicle);
		return 0;
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		super.Aggiorna(vehicle);
		
	}

	@Override
	public void deleteVehicle(long id) {
		super.EliminaById(id);
		
	}

	@Override
	public Vehicle findVehicleById(long id) {
		return super.SelById(id);
		
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		// TODO Auto-generated method stub
		return super.SelTutti();
	}
	public List<Vehicle> findVehiclesByModello(String modello)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<Vehicle> query  = builder.createQuery(Vehicle.class);
    	
    	Root<Vehicle> recordSet = query.from(Vehicle.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("modello"),modello));
    	
    	List<Vehicle> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
	public List<Vehicle> findVehiclesByCasa(String casa)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<Vehicle> query  = builder.createQuery(Vehicle.class);
    	
    	Root<Vehicle> recordSet = query.from(Vehicle.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("casa"),casa));
    	
    	List<Vehicle> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
	public List<Vehicle> findVehiclesByAnno(String anno)
	{
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<Vehicle> query  = builder.createQuery(Vehicle.class);
    	
    	Root<Vehicle> recordSet = query.from(Vehicle.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("anno"),anno));
    	
    	List<Vehicle> result = this.entityManager.createQuery(query).getResultList();
    	return result;
	}
}
