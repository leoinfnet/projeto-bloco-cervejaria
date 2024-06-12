package br.com.acme.cervejaria.filters;

import br.com.acme.cervejaria.model.Estilo;
import br.com.acme.cervejaria.model.Lupulo;
import br.com.acme.cervejaria.model.Marca;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class CervejaFilters {
    private Optional<String> nome;
    private Optional<Estilo> estilo;
    private Optional<Marca> marca;
    private Optional<List<Lupulo>> lupulos;
    private Optional<String> pais;

}
