package br.com.acme.cervejaria.service;

import br.com.acme.cervejaria.filters.CervejaFilters;
import br.com.acme.cervejaria.model.Cerveja;

import java.util.List;
import java.util.Optional;

public interface CervejaService {
    List<Cerveja> getAll();
    Optional<Cerveja> findById(Integer id);
    void deleteById(Integer id);
    void save(Cerveja cerveja);
    Cerveja update(Integer id, Cerveja atualizada);

    List<Cerveja> findWithFilters(CervejaFilters filters);

}
