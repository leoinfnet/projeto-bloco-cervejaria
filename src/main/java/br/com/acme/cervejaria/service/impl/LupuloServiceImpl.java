package br.com.acme.cervejaria.service.impl;

import br.com.acme.cervejaria.model.Lupulo;
import br.com.acme.cervejaria.repository.LupuloRepository;
import br.com.acme.cervejaria.service.LupuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LupuloServiceImpl implements LupuloService {
    private final LupuloRepository lupuloRepository;
    @Override
    public List<Lupulo> findAll() {
        return lupuloRepository.findAll();
    }

    @Override
    public List<Lupulo> findAll(int page, int size, boolean asceding) {
        Sort order = asceding ? Sort.by("nome").ascending() : Sort.by("nome").descending();
        PageRequest pageRequest = PageRequest.of(page, size, order);
        return  lupuloRepository.findAll(pageRequest).stream().toList();
    }

    @Override
    public List<Lupulo> findAllByName(String nome) {
        //List<Lupulo> all = findAll();
        //return all.stream().filter(lupulo -> lupulo.getNome().equals(nome)).toList();
        return lupuloRepository.findAllByNome(nome);
    }

    @Override
    public List<Lupulo> findAllByNameContains(String nome) {
        return lupuloRepository.findAllByNomeContains(nome);
    }
}
