package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.exception.ResourceNotFoundException;
import com.br.model.Marca;
import com.br.repository.MarcaRepository;

@RequestMapping("/cmarca")
@RestController
@CrossOrigin(origins="*")
public class MarcaController {

    @Autowired
    private MarcaRepository mrep;

    @GetMapping
    public List<Marca> listar(){
        return this.mrep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> consultar(@PathVariable Long id) {
        Marca marca = this.mrep.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Marca não encontrada:" + id));
        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public Marca inserir(@RequestBody Marca marca) {
        Marca salva = mrep.save(marca);
        System.out.println("SALVO: " + salva.getNome());
        return salva;
    }
}