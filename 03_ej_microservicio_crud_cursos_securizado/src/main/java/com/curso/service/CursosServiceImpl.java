package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}
	
	@Override
	public Curso buscarCurso(String codCurso) {
		return dao.findByCodCurso(codCurso);
	}
	

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}


	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarDuracionCurso(String codCurso, int duracion) {
		dao.updateDuracion(codCurso, duracion);
	}

	@Override
	public List<Curso> buscarCursoPrecio(int precioMin, int precioMax) {
		return dao.findByPrecios(precioMin, precioMax);

	}


}
