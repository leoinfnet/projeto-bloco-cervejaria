package br.com.acme.cervejaria;

import br.com.acme.cervejaria.model.Estilo;
import br.com.acme.cervejaria.service.EstiloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EstiloServiceTests {
    @Autowired
    EstiloService estiloService;
    @Test
    @DisplayName("Deve retornar todos os estilos")
    public void testaFindAll(){
        List<Estilo> all = estiloService.findAll();
        assertEquals(3, all.size());
    }
    @Test
    @DisplayName("Deve retornar  por ID")
    public void testaFindById(){
        Optional<Estilo> byId = estiloService.findById(1L);
        assertTrue(byId.isPresent());
        Optional<Estilo> naoExistente = estiloService.findById(1000L);
        assertTrue(naoExistente.isEmpty());

    }
}
