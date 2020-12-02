package com.rentalcar.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.webapp.dao.ReservationDao;
import com.rentalcar.webapp.entities.Reservation;
import com.rentalcar.webapp.service.ReservationService;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public long insReservation(Reservation reservation) {
		reservationDao.saveReservation(reservation);
		return 0;
	}

	@Override
	public void elReservationId(long id) {
		// TODO Auto-generated method stub
		reservationDao.deleteReservation(id);
		
	}

	@Override
	public void aggReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.updateReservation(reservation);
		
	}

	@Override
	public Reservation cercaReservationId(long id) {
		// TODO Auto-generated method stub
		return reservationDao.findReservationById(id);
	}

	@Override
	public List<Reservation> trovaTutti() {
		// TODO Auto-generated method stub
		
		return reservationDao.findAllReservations();
	}

	@Override
	public void elReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Reservation> trovaPrenotazioniPerUser(long idUser) {
		// TODO Auto-generated method stub
		
		return reservationDao.findReservationByIdUser(idUser);
	}
	
	@Override
	public void approvaPrenotazione(long id)
	{
		reservationDao.approveReservation(id);
	}
}
