package br.com.controleequipamentosmanutencao.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrdensServicoResponse {

    private String id;
    private String status;
    private String nomePeca;
    private String tipoPeca;
    private String marcaPeca;
    private String nomeCliente;
    private String dataCadastro;
    private String dataInicio;
    private String dataTermino;
    private String descricao;
    private String comentario;

}
