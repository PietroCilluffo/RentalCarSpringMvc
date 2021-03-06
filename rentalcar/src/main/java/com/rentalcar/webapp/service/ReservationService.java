package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.Reservation;


public interface ReservationService {
	long insReservation(Reservation reservation);
	void elReservationId(long id);
	void aggReservation(Reservation reservation);
	Reservation cercaReservationId(long id);
	List<Reservation> trovaTutti();
	List<Reservation> trovaPrenotazioniPerUser(long idUser);
	void elReservation(Reservation reservation);
	void approvaPrenotazione(long id);
}
