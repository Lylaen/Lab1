package it.jaita88.controller;

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

import it.jaita88.model.Recensione;
import it.jaita88.services.RecensioneService;

@Controller
@RequestMapping("/recensioni")
public class RecensioneController {

	@Autowired
	RecensioneService service;

	@GetMapping("/all")
	public String showAllRecensioni(Model model) {
		String title = "Recensioni";
		model.addAttribute("message", title);	
		List<Recensione> recensioni = service.getRecensioni();
		model.addAttribute("recensioni", recensioni);
		return "home";
	}

	@GetMapping("/{id}")
	public String showOneRecensione(@PathVariable("id") Integer id, Model model) {		
		Recensione recensione = service.getRecensioneById(id);		
		List<Recensione> recensioni = new ArrayList<>();
		recensioni.add(recensione);
		String title = "Recensioni";
		model.addAttribute("message", title);
		model.addAttribute("recensioni", recensioni);
		return "home";
	}

	@GetMapping("/delete/{id}")
	public String deleteRecensione(@PathVariable("id") Integer id, Model model) {
		String title = "Recensioni";
		model.addAttribute("message", title);		
		boolean b = service.deleteRecensione(id);		
		List<Recensione> recensioni = service.getRecensioni();
		model.addAttribute("recensioni", recensioni);
		return "home";
	}

	@GetMapping("/add")
	public String showRecensioneForm(Model model) {
		String title = "Aggiungi Recensione";
		model.addAttribute("message", title);
		model.addAttribute("recensione", new Recensione());
		return "recensioneform";
	}

	@PostMapping("/addRecensione")
	public String addRecensione(@ModelAttribute("recensione") Recensione recensione, Model model) {
		
		service.addRecensione(recensione);
		List<Recensione> recensioni = service.getRecensioni();
		model.addAttribute("recensioni", recensioni);
		return "home";
	}

	@GetMapping("/update" + "{id}")
	public String updateRecensione(@PathVariable("id") Integer id, Model model) {
		Recensione a = service.getRecensioneById(id);
		String title = "Modifica recensione";
		model.addAttribute("message", title);
		model.addAttribute("recensione", a);
		return "updateForm";
	}

	@PostMapping("/updateRecensione")
	public String updateRecensione(@ModelAttribute("recensione") Recensione recensione, Integer id, Model model) {
		boolean b = service.updateRecensione(id, recensione);
		List<Recensione> recensioni = service.getRecensioni();
		model.addAttribute("recensioni", recensioni);
		return "home";
	}

}
