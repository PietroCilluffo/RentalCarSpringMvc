package com.rentalcar.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.entities.Vehicle;
import com.rentalcar.webapp.service.VehicleService;

import com.rentalcar.webapp.dto.*;
@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/find")
	public String  GetAllUser(Model model)
	{
		formSearchVehicleDTO searchDTO = new formSearchVehicleDTO();
		List<Vehicle> vehicles = vehicleService.trovaTutti();
		model.addAttribute("vehicles",vehicles);
		model.addAttribute("searchDTO",searchDTO);
		return "parkVehicle"; //deve essere uguale al nome delle tiles
	}
	@GetMapping(value = "/search")
	public String  GetByFilterUser(@ModelAttribute("searchDTO") formSearchVehicleDTO searchDTO, Model model)
	{
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if(searchDTO.getSelected().equals("modello"))
		{
			vehicles = vehicleService.trovaPerModello(searchDTO.getFilter());


		}else if(searchDTO.getSelected().equals( "casa"))
		{
			vehicles = vehicleService.trovaPerCasa(searchDTO.getFilter());
		}else if(searchDTO.getSelected().equals("anno"))
		{
			vehicles = vehicleService.trovaPerAnno(searchDTO.getFilter());
		}else {
			vehicles = vehicleService.trovaTutti();
		}
	
		model.addAttribute("vehicles",vehicles);
		model.addAttribute("searchDTO",searchDTO);
		return "parkVehicle"; //deve essere uguale al nome delle tiles
	}
	
	@GetMapping(value = "/add")
	public String GestAddVehicle(Model model)
	{
		Vehicle vehicle = new Vehicle();
		model.addAttribute("Vehicle",vehicle);
		return "addVehicle";
	}
	
	
	@PostMapping(value = "/add")
	public String Addvehicle(@ModelAttribute("Vehicle") Vehicle vehicle,   Model model)
	{   formSearchVehicleDTO searchDTO = new formSearchVehicleDTO();
		vehicleService.insVehicle(vehicle);
		List<Vehicle> vehicles = vehicleService.trovaTutti();
		model.addAttribute("vehicles",vehicles);
		model.addAttribute("searchDTO",searchDTO);
		return "parkVehicle";
	}
	@GetMapping(value = "/handle/{vehicle.id}")
	public String HandleVehicle( @PathVariable("vehicle.id") long id, Model model)
	{
		Vehicle vehicle = vehicleService.cercaVehicleId(id);
		model.addAttribute("Vehicle",vehicle);
		return "handleVehicle";
		
	}
	@PostMapping(value = "/update")
	public String UpdateUser( @ModelAttribute("Vehicle") Vehicle vehicle, Model model)
	{
		
		
		vehicleService.aggVehicle(vehicle);;
		
		List<Vehicle> vehicles = vehicleService.trovaTutti();
		model.addAttribute("vehicles",vehicles);
		return "redirect:/vehicle/find";
		
	}
	@GetMapping(value = "/delete/{vehicle.id}")
	public String DeleteVehicle( @PathVariable("vehicle.id") long id, Model model)
	{
		vehicleService.elVehicleId(id);
		List<Vehicle> vehicles = vehicleService.trovaTutti();
		model.addAttribute("vehicles",vehicles);
		return "redirect:/vehicle/find";
	}
}
