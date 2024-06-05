package br.com.acme.cervejaria;

import br.com.acme.cervejaria.model.Lupulo;
import br.com.acme.cervejaria.service.LupuloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LupuloServiceTests {
    @Autowired
    LupuloService lupuloService;
    @Test
    @DisplayName("Deve buscar um lupulo pelo nome")
    public void buscaPeloNome(){
        List<Lupulo> result = lupuloService.findAllByName("Ahtanum");
        assertEquals(1, result.size());
        List<Lupulo> startsWithA = lupuloService.findAllByNameContains("A");
        assertEquals(5, startsWithA.size());

    }
}
