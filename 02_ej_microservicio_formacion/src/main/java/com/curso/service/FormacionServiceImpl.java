package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/";

	@Override
	public List<Formacion> buscaFormaciones() {
		List<Curso> listaCursos = null;
		List<Formacion> listaFormaciones = new ArrayList<>();
		listaCursos = Arrays.asList(template.getForObject(url + "cursos", Curso[].class));

		for (Curso curso : listaCursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getCodCurso());
			formacion.setAsignaturas(curso.getDuracion() >= 50 ? 10 : 5);
			formacion.setPrecio(curso.getPrecio());
			
			listaFormaciones.add(formacion);
		}

		return listaFormaciones;
	}

	@Override
	public void nuevaFormacion(Formacion formacion) {
		List<Curso> listaCursos = Arrays.asList(template.getForObject(url + "cursos", Curso[].class));		

		Curso curso = new Curso();
		int duracion = (formacion.getAsignaturas() * 10);
		curso.setNombre(formacion.getCurso());	
		curso.setCodCurso(formacion.getCurso().substring(0, 3) + duracion);
		curso.setDuracion(duracion);
		curso.setPrecio((int) formacion.getPrecio());
		
		if(!listaCursos.stream().filter(c -> c.getNombre().equals(formacion.getCurso())).findFirst().isPresent()){
			template.postForLocation(url + "curso", curso);
		}	
		

	}

}
