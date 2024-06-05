package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.model.Estilo;

import java.util.List;
import java.util.Optional;

public interface EstiloService {
    List<Estilo> findAll();
    Optional<Estilo> findById(Long id);
}
