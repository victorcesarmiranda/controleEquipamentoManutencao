package br.com.controleequipamentosmanutencao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    private String tipo;

    private String marca;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peca", fetch = FetchType.LAZY)
    private List<OrdemServico> ordemServico;

    public Peca(String nome, String tipo, String marca) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
    }
}
