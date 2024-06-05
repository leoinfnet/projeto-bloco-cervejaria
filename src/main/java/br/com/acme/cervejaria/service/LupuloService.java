package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.model.Lupulo;

import java.util.List;

public interface LupuloService {
    List<Lupulo> findAll();
    List<Lupulo>findAll(int page, int size, boolean asceding);
    List<Lupulo> findAllByName(String nome);
    List<Lupulo> findAllByNameContains(String nome);
}
