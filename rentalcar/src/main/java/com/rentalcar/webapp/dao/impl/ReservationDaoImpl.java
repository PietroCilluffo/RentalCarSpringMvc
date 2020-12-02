package com.rentalcar.webapp.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rentalcar.webapp.dao.AbstractDao;
import com.rentalcar.webapp.dao.ReservationDao;
import com.rentalcar.webapp.entities.Reservation;


@Repository 
public class ReservationDaoImpl extends AbstractDao<Reservation,Long>
implements ReservationDao{

	@Override
	public int saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		super.Inserisci(reservation);
		return 0;
	}

	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		super.Aggiorna(reservation);
	}

	@Override
	public void deleteReservation(long id) {
		// TODO Auto-generated method stub
		super.EliminaById(id);
	}

	@Override
	public List<Reservation> findAllReservations() {
		// TODO Auto-generated method stub
		
		return super.SelTutti();
	}
    @Override
    public  List<Reservation>  findReservationByIdUser(long idUser) {
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<Reservation> query  = builder.createQuery(Reservation.class);
    	
    	Root<Reservation> recordSet = query.from(Reservation.class);
    	query.select(recordSet).where(builder.equal(recordSet.get("user"),idUser));
    	
    	List<Reservation> result = this.entityManager.createQuery(query).getResultList();
    	
    	return result;
    }
    @Override
    public void approveReservation(long id)
    {
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaUpdate<Reservation> query = builder.createCriteriaUpdate(Reservation.class);
    	Root<Reservation> root = query.from(Reservation.class);
    	query.set(root.get("approvazione"),true);
    	
    	query.where(builder.equal(root.get("id"), id));
    	this.entityManager.createQuery(query).executeUpdate();
    }
    @Override
    public Reservation findReservationById(long id)
    {
    	return super.SelById(id);
    }
}
