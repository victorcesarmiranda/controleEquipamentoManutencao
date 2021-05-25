package br.com.controleequipamentosmanutencao.service;

import br.com.controleequipamentosmanutencao.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    /**
     * Cria um objeto Cliente com os parametros nome, endereço telefone e email.
     *
     * @param nome
     * @param endereco
     * @param telefone
     * @param email
     * @return um objeto Cliente, pronto para ser incluido no banco de dados.
     */
    public Cliente criaCliente(String nome, String endereco, String telefone, String email) {
        return new Cliente(nome, endereco, telefone, email);
    }

}
