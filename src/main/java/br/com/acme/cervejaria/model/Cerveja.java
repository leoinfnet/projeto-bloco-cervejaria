package br.com.acme.cervejaria.model;

import br.com.acme.cervejaria.service.EstiloService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "estilo_id")
    private Estilo estilo;
    @ManyToOne
    private Marca marca;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Lupulo> lupulos;

    @Override
    public String toString() {
        return "Cerveja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estilo=" + estilo +
                ", marca=" + marca +
                ", lupulos=" + lupulos +
                '}';
    }
}
//POJO - Plain OLD JAVA OBJECT -> GETTER E SETTERS CONTRUTOR PADRAO ()