package br.com.controleequipamentosmanutencao.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequisicaoIniciaOrdemServico {

    private String id;

    @NotNull
    private String dataInicio;

    private String dataTermino;

    private String comentario;

}
