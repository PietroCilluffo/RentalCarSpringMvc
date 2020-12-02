package com.rentalcar.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentalcar.webapp.entities.Reservation;
import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.service.ReservationService;
import com.rentalcar.webapp.service.UserService;

import com.rentalcar.webapp.dto.*;

@Controller
@RequestMapping("/user")
public class UserController {

	//code injection dello stato di servizio che a sua volta avrà il code injection dello stato di persistenza
	@Autowired
	private UserService userService;

	@Autowired
	private ReservationService reservationService;


	@GetMapping(value = "/find")
	public String  GetAllUser(Model model)
	{
		formSearchUserDTO searchDTO = new formSearchUserDTO() ;
		List<User> users = userService.trovaTutti();
		model.addAttribute("users",users);
		model.addAttribute ("searchDTO",searchDTO);
		return "Home"; //deve essere uguale al nome delle tiles
	}

	@GetMapping(value = "/add")
	public String GestAddUser(Model model)
	{
		User user = new User();
		model.addAttribute("User",user);
		return "addUser";
	}


	@PostMapping(value = "/add")
	public String AddUser(@ModelAttribute("User") User user,   Model model)
	{   
		formSearchUserDTO searchDTO = new formSearchUserDTO() ;
		userService.insUser(user);
		List<User> users = userService.trovaTutti();
		model.addAttribute("users",users);
		model.addAttribute ("searchDTO",searchDTO);
		return "Home";
	}

	@GetMapping(value = "/handle/{user.id}")
	public String HandleUser( @PathVariable("user.id") long id, Model model)
	{
		List<Reservation> reservations = reservationService.trovaPrenotazioniPerUser(id);

		User user = userService.cercaUserId(id);
		model.addAttribute("User",user);
		model.addAttribute("reservations",reservations);
		return "handleUser";

	}
	@GetMapping(value = "/delete/{user.id}")
	public String DeleteUser( @PathVariable("user.id") long id, Model model)
	{
		userService.elUserId(id);
		List<User> users = userService.trovaTutti();
		model.addAttribute("users",users);
		return "redirect:/user/find";
	}
	@PostMapping(value = "/update")
	public String UpdateUser( @ModelAttribute("User") User user, Model model)
	{
		System.out.println(user.getId());
		System.out.println(user.getNome());

		userService.aggUser(user);

		List<User> users = userService.trovaTutti();
		model.addAttribute("users",users);
		return "redirect:/user/find";

	}

	@GetMapping(value = "/search")
	public String  GetUserByFilter(@ModelAttribute("searchDTO") formSearchUserDTO searchDTO ,Model model)
	{
		List<User> users = new ArrayList<User>();
		if(searchDTO.getSelected().equals("nome"))
		{
			users = userService.trovaPerNome(searchDTO.getFilter());


		}else if(searchDTO.getSelected().equals( "cognome"))
		{
			users = userService.trovaPerCognome(searchDTO.getFilter());
		}else if(searchDTO.getSelected().equals("email"))
		{
			users = userService.trovaPerCognome(searchDTO.getFilter());
		}else {
			users = userService.trovaTutti();
		}
		model.addAttribute("users",users);
		return "Home"; //deve essere uguale al nome delle tiles
	}
}
