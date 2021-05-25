package br.com.controleequipamentosmanutencao.model;

import br.com.controleequipamentosmanutencao.enums.StatusOrdemServico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Peca peca;

    @Column(length = 500)
    private String descricao;

    @Column(length = 500)
    private String comentario;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    private LocalDateTime dataInicio;

    private LocalDateTime dataTermino;

    private LocalDateTime dataCadastro;

    public OrdemServico(Cliente cliente, Peca peca, String descricao, LocalDateTime dataInicio, LocalDateTime dataTermino) {
        this.cliente = cliente;
        this.peca = peca;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.dataCadastro = LocalDateTime.now();
        this.status = StatusOrdemServico.PENDENTE;
    }
}
