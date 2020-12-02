package com.rentalcar.webapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentalcar.webapp.entities.Reservation;
import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.entities.Vehicle;
import com.rentalcar.webapp.service.ReservationService;
import com.rentalcar.webapp.service.VehicleService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping(value = "/add/{user.id}")
	public String GestAddReservation( @PathVariable("user.id") long id, Model model)
	{
		User user = new User();
		user.setId(id);
	
	

		Reservation reservation = new Reservation();
		reservation.setUser(user);
		List<Vehicle> vehicles = vehicleService.trovaTutti();

		model.addAttribute("vehicles",vehicles);
		model.addAttribute("Reservation",reservation);
		
		return "addReservation";
	}
	@PostMapping(value = "/add")
	public String AddReservation( @ModelAttribute("Reservation") Reservation reservation,  Model model)
	{  
		System.out.println(reservation.getDataFine());
		reservationService.insReservation(reservation);
		return "redirect:/reservation/find/"+reservation.getUser().getId(); //da definire
	}
	
	@GetMapping(value = "/find/{user.id}")
	public String ShowReservationByUser(@PathVariable("user.id") long idUser, Model model)
	{
		List<Reservation> reservations = reservationService.trovaPrenotazioniPerUser(idUser);
		model.addAttribute("reservations",reservations);
		return "Home";
	}
	
	@GetMapping(value = "/approve/{user.id}/{reservation.id}")
	public String ApprovaPrenotazione(@PathVariable("reservation.id") long id, Model model)
	{
		reservationService.approvaPrenotazione(id);
		return "redirect:/user/handle/{user.id}";
	}
	
	@GetMapping (value = "/handle/{reservation.id}")
	public String GestPrenotazione (@PathVariable("reservation.id") long id, Model model)
	{
		Reservation reservation = reservationService.cercaReservationId(id);
	
		model.addAttribute("Reservation",reservation);
		return "handleReservation";
	}
	
	@PostMapping (value = "/update")
	public String UpdatePrenotazione(@ModelAttribute("Reservation") Reservation reservation, Model model)
	{
		reservationService.aggReservation(reservation);
		return "redirect:/reservation/find/"+reservation.getUser().getId();
	}
	@GetMapping (value = "/delete/{reservation.user.id}/{reservation.id}")
	public String ElPrenotazione (@PathVariable("reservation.id") long id, Model model)
	{
		reservationService.elReservationId(id);
		

		return "redirect:/reservation/find/{reservation.user.id}";
	}
}
