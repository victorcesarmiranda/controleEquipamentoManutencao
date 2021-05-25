package br.com.controleequipamentosmanutencao.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequisicaoNovaOrdemServico {

    @NotBlank
    private String nome;

    private String endereco;

    private String telefone;

    @Email
    private String email;

    @NotBlank
    private String peca;

    private String tipo;

    private String marca;

    @NotBlank
    private String descricao;

    private String dataInicio;

    private String dataTermino;

}
