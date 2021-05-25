package br.com.controleequipamentosmanutencao.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequisicaoFinalizaOrdemServico {

    private String id;

    @NotNull
    private String dataTermino;

    @NotBlank
    private String comentario;

}
