package com.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Formacion;

public interface FormacionService {
	List<Formacion> buscaFormaciones();
	
	void nuevaFormacion(Formacion formacion);

}
