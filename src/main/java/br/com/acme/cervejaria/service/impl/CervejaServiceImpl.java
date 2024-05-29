package br.com.acme.cervejaria.service.impl;


import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.repository.CervejaRepository;
import br.com.acme.cervejaria.service.CervejaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CervejaServiceImpl implements CervejaService {
    private final CervejaRepository cervejaRepository;
    @Override
    public List<Cerveja> getAll() {
        return cervejaRepository.findAll();
    }
    @Override
    public Optional<Cerveja> findById(Integer id) {
        return cervejaRepository.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        cervejaRepository.deleteById(id);
    }
    @Override
    public void save(Cerveja cerveja) {
        cervejaRepository.save(cerveja);
    }
    @Override
    public Cerveja update(Integer id, Cerveja atualizada) {
        atualizada.setId(id);
        return cervejaRepository.save(atualizada);
    }

}
