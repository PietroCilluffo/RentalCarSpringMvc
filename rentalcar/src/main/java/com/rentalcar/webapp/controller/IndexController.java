package com.rentalcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentalcar.webapp.dto.*;
@Controller //in questa maniera spring sa come cercare i controller
public class IndexController {
	
	@RequestMapping(value = "index")  //tutte le pagine che avranno nell'url index saranno gestite da questo controller
	public String getWelcome (Model model)
	{
		model.addAttribute("intestazione", "Benvenuti");
		
		return "index";  //lo stesso nome del tiles.xml
	}
	@RequestMapping(value = "/")  //tutte le pagine che avranno nell'url index saranno gestite da questo controller
	public String getWelcome2 (Model model)
	{
		formLoginDTO loginDTO = new formLoginDTO();
		model.addAttribute("intestazione", "Benvenuti");
		model.addAttribute("loginDTO", loginDTO);
		return "index";
	}
	
    
	
	
}
