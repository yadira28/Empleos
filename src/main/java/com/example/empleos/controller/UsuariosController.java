package com.example.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.empleos.model.Usuario;
import com.example.empleos.service.IUsuariosService;
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Usuario> lista = serviceUsuarios.buscarTodos();
		model.addAttribute("usuarios", lista);
    	return "usuarios/listUsuarios";
	}
    
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		System.out.println("Borrando categoria con id:" + idUsuario);
		serviceUsuarios.eliminar(idUsuario);
		attributes.addFlashAttribute("msg","El usuario fue eliminado!");
		return "redirect:/usuarios/index";
	}

}
