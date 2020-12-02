package com.rentalcar.webapp.dao;

import java.util.List;

import com.rentalcar.webapp.entities.Reservation;

public interface ReservationDao {
	int saveReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(long id);
    void approveReservation(long id);
    Reservation findReservationById(long id);
    List<Reservation>  findReservationByIdUser(long idUser);
    List<Reservation> findAllReservations();
}
