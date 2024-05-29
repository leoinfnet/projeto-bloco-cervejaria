package br.com.acme.cervejaria.repository;

import br.com.acme.cervejaria.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja,Integer> {
}
