package br.com.acme.cervejaria.service.impl;

import br.com.acme.cervejaria.model.Estilo;
import br.com.acme.cervejaria.repository.EstiloRepository;
import br.com.acme.cervejaria.service.EstiloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstiloServiceImpl implements EstiloService {

    private final EstiloRepository estiloRepository;

    @Override
    public List<Estilo> findAll() {

        return estiloRepository.findAll();

    }

    @Override
    public Optional<Estilo> findById(Long id) {
        return estiloRepository.findById(id);
    }

}
