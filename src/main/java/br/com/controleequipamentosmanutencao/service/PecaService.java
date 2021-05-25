package br.com.controleequipamentosmanutencao.service;

import br.com.controleequipamentosmanutencao.model.Peca;
import org.springframework.stereotype.Service;

@Service
public class PecaService {
    /**
     * Cria um objeto Peça com os parametros nome, tipo, e marca.
     *
     * @param nome
     * @param tipo
     * @param marca
     * @return um objeto Peça, pronto para ser incluído no banco de dados.
     */
    public Peca criaPeca(String nome, String tipo, String marca) {
        return new Peca(nome, tipo, marca);
    }
}
