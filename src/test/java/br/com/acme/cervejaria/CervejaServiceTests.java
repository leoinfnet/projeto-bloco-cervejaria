package br.com.acme.cervejaria;

import br.com.acme.cervejaria.model.Cerveja;
import br.com.acme.cervejaria.model.Estilo;
import br.com.acme.cervejaria.model.Lupulo;
import br.com.acme.cervejaria.model.Marca;
import br.com.acme.cervejaria.service.CervejaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class CervejaServiceTests {
    @Autowired
    CervejaService cervejaService;
    @Test
    @DisplayName("Deve inserir uma cerveja no Banco.")
    public void testaInsert(){
        Estilo estilo = Estilo.builder().id(1L).build();
        Marca marca = Marca.builder().id(1L).build();
        List<Cerveja> all = cervejaService.getAll();
        int estadoInicial = all.size();
        Cerveja cerveja = new Cerveja();
        cerveja.setNome("Whals Petroleum");
        cerveja.setEstilo(estilo);
        cerveja.setMarca(marca);
        cervejaService.save(cerveja);
        all = cervejaService.getAll();
        int estadoFinal = all.size();
        //if(estadoFinal == estadoInicial + 1) // TestePassou
        assertEquals(estadoInicial + 1,estadoFinal);
    }
    @Test
    @DisplayName("Deve Deletar uma cerveja do banco")
    public void testaDelete(){
        Cerveja cerveja = new Cerveja();
        cerveja.setNome("Whals Petroleum");
        //cerveja.setTipo("Belgian Tripel");
        cervejaService.save(cerveja);
        List<Cerveja> all = cervejaService.getAll();
        int estadoInicial = all.size();
        Cerveja cerveja2 = all.get(0);
        cervejaService.deleteById(cerveja2.getId());
        all = cervejaService.getAll();
        int estadoFinal = all.size();
        assertEquals(estadoInicial - 1, estadoFinal);
    }
    @Test
    @DisplayName("Deve retornar uma cerveja pelo ID")
    public void testGetById(){
        //Cerveja cerveja = new Cerveja();
        //cerveja.setNome("Whals Petroleum");
        //cerveja.setTipo("Belgian Tripel");
        //cervejaService.save(cerveja);
        //List<Cerveja> all = cervejaService.getAll();
        //Cerveja cerveja2 = all.get(0);
        //Optional<Cerveja> byId = cervejaService.findById(cerveja2.getId());
        //assertTrue(byId.isPresent());
        //Optional<Cerveja> cervejaInexistente = cervejaService.findById(-1);
        //assertTrue(cervejaInexistente.isEmpty());
        Cerveja cerveja = cervejaService.findById(1).get();
        List<Lupulo> lupulos = cerveja.getLupulos();
        log.info("Lupulos: " + lupulos);
//        log.info("Cerveja: " +  cerveja);



    }


}
