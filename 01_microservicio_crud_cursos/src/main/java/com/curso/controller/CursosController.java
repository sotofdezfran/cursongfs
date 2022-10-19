package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {
	
	@Autowired
	CursosService service;
	

	@GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listaLibros() {
		return service.cursos();
	}
	
	@PostMapping(value="curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> alta(@RequestBody Curso curso) {
		return service.altaCurso(curso);
	}	

	@GetMapping(value="curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}	


	@DeleteMapping(value="curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable("codCurso") String codCurso) {
		return service.eliminarCurso(codCurso);
	}
	

	
	@PutMapping(value="curso/{codCurso}/{duracion}")
	public void actualizarduracion(@PathVariable("codCurso") String codCurso, @PathVariable("duracion") int duracion) {
		service.actualizarDuracionCurso(codCurso, duracion);
	}
	
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarPorPrecios(@PathVariable("precioMin") int precioMin, @PathVariable("precioMax") int precioMax) {
		return service.buscarCursoPrecio(precioMin, precioMax);
	}	
	
	
}
