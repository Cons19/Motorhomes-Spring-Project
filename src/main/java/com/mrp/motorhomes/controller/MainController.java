package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	public static User currentUser = null;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("users", User.ALL_USERS);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("type") String type){
		for(User user : User.ALL_USERS) {
			if(user.getType().equals(type)){
				currentUser = user;
			}
		}
		
		System.out.println(currentUser);
		if(currentUser.getType().equals(User.TYPES[0])){
			return "redirect:/customers/";
		}
		else if(currentUser.getType().equals(User.TYPES[2])){
			return "redirect:/rentals/";
		}
		else{
			return "redirect:/motorhomes/";
		}
	}
}