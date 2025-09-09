package com.example.sorveteria.service;

import com.example.sorveteria.model.Sorvete;
import com.example.sorveteria.repository.SorveteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SorveteService {
    private final SorveteRepository repo;

    public SorveteService(SorveteRepository repo) {
        this.repo = repo;
    }

    public List<Sorvete> listar() {
        return repo.findAll();
    }

    public Optional<Sorvete> buscar(Long id) {
        return repo.findById(id);
    }

    public Sorvete salvar(Sorvete s) {
        return repo.save(s);
    }

    public Optional<Sorvete> atualizar(Long id, Sorvete novo) {
        return repo.findById(id).map(s -> {
            s.setSabor(novo.getSabor());
            s.setPreco(novo.getPreco());
            s.setDisponivel(novo.getDisponivel());
            return repo.save(s);
        });
    }

    public boolean deletar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
