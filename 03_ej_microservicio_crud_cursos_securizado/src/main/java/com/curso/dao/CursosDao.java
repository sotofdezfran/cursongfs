package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {
	
	@Query("SELECT c FROM Curso c WHERE c.codCurso =:codCurso")
	Curso findByCodCurso(@Param("codCurso") String codCurso);
	
	@Transactional
	@Modifying
	@Query("UPDATE Curso c SET c.duracion =:duracion WHERE c.codCurso =:codCurso")
	void updateDuracion(@Param("codCurso") String codCurso, @Param("duracion") int duracion);
	
	@Query("Select c FROM Curso c WHERE c.precio >= :precioMin AND c.precio <= :precioMax")
	List<Curso> findByPrecios(@Param("precioMin") int precioMin, @Param("precioMax") int precioMax);
	


}
