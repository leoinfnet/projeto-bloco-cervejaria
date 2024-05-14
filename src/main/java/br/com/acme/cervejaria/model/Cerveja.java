package br.com.acme.cervejaria.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
public class Cerveja {
    @NotBlank
    private int codigo;
    @NotBlank
    @Size(min = 0, max = 20)
    private String nome;
    private String tipo;
}
