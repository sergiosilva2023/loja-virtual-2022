package com.dev.backend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.backend.entity.Distrito;
import com.dev.backend.service.DistritoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/")
    public List<Distrito> buscarTodos() {
        return distritoService.buscarTodos();
    }

    @PostMapping("/")
    public Distrito inserir(@RequestBody Distrito distrito) {
        return distritoService.inserir(distrito);
    }

    @PutMapping("/")
    public Distrito alterar(@RequestBody Distrito distrito) {
        return distritoService.alterar(distrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        distritoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
