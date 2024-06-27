package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.backend.entity.Marcas;
import com.dev.backend.service.MarcasService;

@RestController
@RequestMapping("/api/marcas")
public class MarcasController {
    
    @Autowired
    private MarcasService marcasService;

    @GetMapping("/")
    public List<Marcas> buscarTodos() {
        return marcasService.buscarTodos();
    }

    @PostMapping("/")
    public Marcas inserir(@RequestBody Marcas marcas) {
        return marcasService.inserir(marcas);
    }

    @PutMapping("/")
    public Marcas alterar(@RequestBody Marcas marcas) {
        return marcasService.alterar(marcas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        marcasService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
