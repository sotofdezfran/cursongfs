package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	
	List<Curso> cursos();	
	List<Curso> altaCurso(Curso curso);
	
	List<Curso> eliminarCurso(String codCurso);
	void actualizarDuracionCurso(String codCurso, int duracion);
	Curso buscarCurso(String codCurso);
	List<Curso> buscarCursoPrecio(int precioMin, int precioMax);
}
