package br.com.acme.cervejaria.repository;

import br.com.acme.cervejaria.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long> {
}
