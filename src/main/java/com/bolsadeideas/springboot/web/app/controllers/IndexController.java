package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuarios;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Fracon Model!");
		return "index";
	}
	
	@RequestMapping("/perfil") // Ruta Url
	public String perfil(Model model) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre("Bryan");
		usuario.setApellido("Lima");
		usuario.setEdad(25);
		usuario.setEmail("bryan.augusto_lima@yahoo.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Perfil de usuario:".concat(usuario.getNombre()));
		return "perfil"; // Ruta archivo HTML
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listar usuarios:");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuarios> poblarUsuarios(){
		List<Usuarios> usuarios = Arrays.asList(
				new Usuarios("Bryan","Augusto",25,"bryan.augusto_lima@yahoo.com"),
				new Usuarios("Jose","Homero",22,"jose.homero@yahoo.com"),
				new Usuarios("Leticia","Lima",18,"leticia.lima@yahoo.com"),
				new Usuarios("Homero","Mario",45,"homero.mario@yahoo.com"),
				new Usuarios("Mario","Davi",35,"mario.davi@yahoo.com"),
				new Usuarios("Davi","Mario",36,"davi.mario@yahoo.com"));
		
		return usuarios;
	}
}
