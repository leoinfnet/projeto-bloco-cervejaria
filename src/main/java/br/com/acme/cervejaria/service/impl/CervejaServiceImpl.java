package br.com.acme.cervejaria.service.impl;


import br.com.acme.cervejaria.filters.CervejaFilters;
import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.model.Lupulo;
import br.com.acme.cervejaria.repository.CervejaRepository;
import br.com.acme.cervejaria.service.CervejaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CervejaServiceImpl implements CervejaService {
    private final CervejaRepository cervejaRepository;
    private final EntityManager entityManager;
    @Override
    public List<Cerveja> findWithFilters(CervejaFilters filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cerveja> cq = cb.createQuery(Cerveja.class);
        Root<Cerveja> cerveja = cq.from(Cerveja.class);
        List<Predicate> predicates = new ArrayList<>();
        if (filters.getNome().isPresent()) {
            String query = filters.getNome().get() + "%";
            Predicate nome = cb.like(cerveja.get("nome"), query);
            predicates.add(nome);
        }
        if(filters.getEstilo().isPresent()){
            Predicate estilo = cb.equal(cerveja.get("estilo"), filters.getEstilo().get());
            predicates.add(estilo);
        }
        if(filters.getMarca().isPresent()){
            Predicate marca = cb.equal(cerveja.get("marca"), filters.getMarca().get());
            predicates.add(marca);
        }
        if(filters.getPais().isPresent()){
            Predicate pais = cb.equal(cerveja.get("marca").<String>get("pais"), filters.getPais().get());
            predicates.add(pais);
        }
        if(filters.getLupulos().isPresent()){
            List<Integer> ids = getIds(filters);
            Predicate lupulos = cerveja.join("lupulos").get("id").in(ids);
            predicates.add(lupulos);
        }
        if(false){
            Predicate dataFabricacao = cb.between(cerveja.get("dataFabricacao"), LocalDate.now(), LocalDate.now().minusDays(5));
            predicates.add(dataFabricacao);
        }
        Predicate[] array = predicates.toArray(Predicate[]::new);
        cq.where(predicates.toArray(Predicate[]::new));
        List<Cerveja> resultList = entityManager.createQuery(cq).getResultList();
        return resultList;
    }

    private  List<Integer> getIds(CervejaFilters filters) {
        return filters.getLupulos().get().stream().map(Lupulo::getId).toList();
    }


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
