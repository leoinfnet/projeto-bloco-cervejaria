package br.com.acme.cervejaria.repository;

import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.model.Lupulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LupuloRepository extends JpaRepository<Lupulo,Long> {
    List<Lupulo> findAllByNome(String nome);
    List<Lupulo> findAllByNomeContains(String nome);


    List<Lupulo> findAllByNomeContainsOrDescricaoContains(String nome, String descricao);
    //List<Lupulo> findAllByCervejaId(Cerveja cerveja);
}
