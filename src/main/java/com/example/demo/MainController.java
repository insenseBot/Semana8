package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.String;

@Controller	
@RequestMapping(path="/")
public class MainController {
	@Autowired
	private CursoRepository cursoRepository;
    
    // Operaciones sin Base de Datos
    @GetMapping(path="/")
	public @ResponseBody String home() {
		return "Bryan Retamozo";
	}

    @GetMapping(path="/codigo")
	public @ResponseBody String codigo() {
		return "SL78781161";
	}

    @GetMapping(path="/nombre-completo")
	public @ResponseBody String nombreCompleto() {
		return "Bryan Retamozo - SL78781161";
	}

	// Operaciones con Base de Datos
    @GetMapping(path="/api/curso/listar")
	public @ResponseBody Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}
    
	@PostMapping(path="/api/curso/nuevo")
	public @ResponseBody String addNewCurso (@RequestParam String nombre
			, @RequestParam Integer creditos) {
		Curso c = new Curso();
		c.setNombre(nombre);
		c.setCreditos(creditos);
		cursoRepository.save(c);
		return "Curso Saved";
	}

	@DeleteMapping(path="/api/curso/eliminar")
	public @ResponseBody String delCurso (@RequestParam Integer id) {
		Curso c = new Curso();
		c.setId(id);
		cursoRepository.delete(c);
		return "Curso Deleted";
	}
}