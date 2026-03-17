package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}