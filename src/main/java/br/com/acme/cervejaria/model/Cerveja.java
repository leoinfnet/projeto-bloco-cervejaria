package br.com.acme.cervejaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
public class Cerveja {
    private int codigo;
    private String nome;
    private String tipo;
}
