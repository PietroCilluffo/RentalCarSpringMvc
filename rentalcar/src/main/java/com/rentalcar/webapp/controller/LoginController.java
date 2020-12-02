package com.rentalcar.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentalcar.webapp.dto.formLoginDTO;
import com.rentalcar.webapp.entities.User;
import com.rentalcar.webapp.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserService userService;
	@PostMapping(value = "")  
	public String checkUser (@ModelAttribute("loginDTO")formLoginDTO loginDTO, Model model, HttpServletRequest request)
	{
	    List<User> users = userService.trovaPerEmail(loginDTO.getEmail());
	    User user = users.get(0);
	    String email = user.getEmail();
	    String password = user.getPassword();
	    if(loginDTO.getPassword().equals(password)) {
	    	if(user.getTipo().equals("u")) {
	    		HttpSession oldSession = request.getSession(false);   //ricavo la sessione e la setto

				if(oldSession!=null) {
					oldSession.invalidate();

				}    
				HttpSession currentSession = request.getSession(); 
				long id = user.getId();
	            currentSession.setAttribute("nome", user.getNome());
				currentSession.setAttribute("email", email);
				currentSession.setAttribute("id",id);
				currentSession.setAttribute("isSuper", 0);
			
				return "redirect:/reservation/find/"+id;
	    	}else {
	    		HttpSession oldSession = request.getSession(false);   //ricavo la sessione e la setto

				if(oldSession!=null) {
					oldSession.invalidate();

				}    
				HttpSession currentSession = request.getSession(); 
				long id = user.getId();
	            currentSession.setAttribute("nome", user.getNome());
				currentSession.setAttribute("email", email);
				currentSession.setAttribute("id",id);
				currentSession.setAttribute("isSuper", 1);
				return "redirect:/user/find";
	    	}
	    }else {
	    	return "index";
	    }
		
		
		
	}
}
