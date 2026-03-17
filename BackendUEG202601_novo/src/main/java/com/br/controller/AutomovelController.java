package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.exception.ResourceNotFoundException;
import com.br.model.Automovel;
import com.br.repository.AutomovelRepository;

@RestController
@RequestMapping("/cautomovel")
@CrossOrigin(origins = "*")
public class AutomovelController {

    @Autowired
    private AutomovelRepository arep;

    @GetMapping("/automovel")
    public List<Automovel> listar() {
        return this.arep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
    }

    @GetMapping("/automovel/{id}")
    public ResponseEntity<Automovel> consultar(@PathVariable Long id) {
        Automovel automovel = this.arep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Automóvel não encontrado: " + id));
        return ResponseEntity.ok(automovel);
    }

    @PostMapping("/automovel")
    public Automovel inserir(@RequestBody Automovel automovel) {
        return this.arep.save(automovel);
    }
}