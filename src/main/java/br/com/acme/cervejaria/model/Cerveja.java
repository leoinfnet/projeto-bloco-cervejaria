package br.com.acme.cervejaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
@Entity
@Table(name = "CERVEJA")
public class Cerveja {
    @NotBlank
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 0, max = 20)
    private String nome;
    @Column(name = "tipo_cerveja")
    private String tipo;
}
//POJO - Plain OLD JAVA OBJECT -> GETTER E SETTERS CONTRUTOR PADRAO ()