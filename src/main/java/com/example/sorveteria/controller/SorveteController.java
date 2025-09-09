package com.example.sorveteria.controller;

import com.example.sorveteria.model.Sorvete;
import com.example.sorveteria.service.SorveteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/sorvetes")
public class SorveteController {
    private final SorveteService service;

    public SorveteController(SorveteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sorvete> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sorvete> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sorvete salvar(@RequestBody Sorvete s) {
        return service.salvar(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sorvete> atualizar(@PathVariable Long id, @RequestBody Sorvete novo) {
        return service.atualizar(id, novo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.deletar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
