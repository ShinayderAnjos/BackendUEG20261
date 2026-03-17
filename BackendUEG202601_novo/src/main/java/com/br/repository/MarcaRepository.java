package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Marca;

public interface MarcaRepository  extends JpaRepository<Marca, Long>{
	
	

}