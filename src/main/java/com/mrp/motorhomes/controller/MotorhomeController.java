package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorhomeController {
	private CrudRepository<Motorhome> repository;
	
	public MotorhomeController() {
		repository = new MotorhomeRepository();
	}

	@GetMapping("/motorhomes")
	public String index(Model model) {
		model.addAttribute("moto", repository.readAll());
		return "index";
	}

	@GetMapping("/create")
	public String create() {
		return "create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Motorhome motorhome) {
		repository.create(motorhome);
		return "redirect:/";
	}

	@GetMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		Motorhome motorhome = (Motorhome)repository.read(id);
		model.addAttribute("moto", motorhome);
		return "details";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Motorhome motorhome) {
        repository.update(motorhome);
	    return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute Motorhome motorhome) {
        repository.delete(motorhome.getId());
        return "redirect:/";
	}

}