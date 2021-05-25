package br.com.controleequipamentosmanutencao.service;

import br.com.controleequipamentosmanutencao.dto.RequisicaoFinalizaOrdemServico;
import br.com.controleequipamentosmanutencao.dto.RequisicaoIniciaOrdemServico;
import br.com.controleequipamentosmanutencao.dto.RequisicaoNovaOrdemServico;
import br.com.controleequipamentosmanutencao.enums.StatusOrdemServico;
import br.com.controleequipamentosmanutencao.model.Cliente;
import br.com.controleequipamentosmanutencao.model.OrdemServico;
import br.com.controleequipamentosmanutencao.model.Peca;
import br.com.controleequipamentosmanutencao.repository.OrdemServicoRepository;
import br.com.controleequipamentosmanutencao.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    PecaService pecaService;

    /**
     * Cria um objeto OrdemServiço a partir de uma RequisicaoNovaOrdemServico, que é o
     * objeto que contem os dados vindos do formulário preenchido pelo usuário para incluir
     * a nova Ordem de Serviço.
     *
     * Este método também já cria os modelos Cliente e Peça, para que sejam incluídos em uma
     * única chamada do método save do repositório da Ordem de serviço.
     *
     * @param requisicaoNovaOrdemServico
     * @return
     */
    public OrdemServico criaOrdemServico(RequisicaoNovaOrdemServico requisicaoNovaOrdemServico) {
        Cliente cliente = clienteService
                .criaCliente(requisicaoNovaOrdemServico.getNome(),
                        requisicaoNovaOrdemServico.getEndereco(),
                        requisicaoNovaOrdemServico.getTelefone(),
                        requisicaoNovaOrdemServico.getEmail());
        Peca peca = pecaService
                .criaPeca(requisicaoNovaOrdemServico.getPeca(),
                        requisicaoNovaOrdemServico.getTipo(),
                        requisicaoNovaOrdemServico.getMarca());
        LocalDateTime dataInicio = AppUtil.getLocalDateTime(requisicaoNovaOrdemServico.getDataInicio());
        LocalDateTime dataTermino = AppUtil.getLocalDateTime(requisicaoNovaOrdemServico.getDataTermino());


        return new OrdemServico(cliente, peca, requisicaoNovaOrdemServico.getDescricao(), dataInicio, dataTermino);
    }

    /**
     * Salva uma Ordem de Serviço no banco de dados, podendo salvar também os objetos Cliente
     * e Peça em suas respectivas tabelas caso estejam devidamente preenchidos.
     * @param ordemServico
     */
    public void save(OrdemServico ordemServico) {
        ordemServicoRepository.save(ordemServico);
    }

    /**
     * Deleta uma ordem de serviço do banco de dados, passando o id do registro como argumento
     * @param id
     */
    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    /**
     * Faz uma consulta as banco de dados, trazendo as dez últimas ordens de serviço cadastradas,
     * ordenadas da data mais atual para a data mais antiga.
     *
     * @return uma lista do objeto OrdemServico ordenados pelo atributo data cadastro.
     */
    public List<OrdemServico> findDezUltimasOrdensServico() {
        return ordemServicoRepository.findAll(PageRequest.of(0, 10, Sort.by("dataCadastro").descending())).getContent();
    }

    /**
     * Faz uma consulta no banco de dados, buscando todas as Ordens de Serviço que possuam
     * o status passado como argumento.
     *
     * @param status
     * @return uma lista do objeto OrdemServico que possuam o mesmo status
     */
    public List<OrdemServico> findAllByStatus (StatusOrdemServico status) {
        return ordemServicoRepository.findAllByStatus(status, PageRequest.of(0, 10, Sort.by("dataCadastro")));
    }

    /**
     * Muda o status de uma Ordem de Serviço para INICIADA. A Ordem de serviço que será alterada,
     * será a que possui o valor do id que está no objeto RequisicaoIniciaOrdemServico.id.
     *
     * Também será possível setar os valores dos campos data de início, data de término e comentário,
     * se preenchidos, da Ordem de Serviço.
     *
     * @param requisicaoIniciaOrdemServico
     */
    public void iniciaOrdemServico(RequisicaoIniciaOrdemServico requisicaoIniciaOrdemServico) {
        OrdemServico ordemServico = ordemServicoRepository.getById(Long.valueOf(requisicaoIniciaOrdemServico.getId()));
        ordemServico.setDataInicio(AppUtil.getLocalDateTime(requisicaoIniciaOrdemServico.getDataInicio()));
        ordemServico.setDataTermino(AppUtil.getLocalDateTime(requisicaoIniciaOrdemServico.getDataTermino()));
        ordemServico.setComentario(requisicaoIniciaOrdemServico.getComentario());
        ordemServico.setStatus(StatusOrdemServico.INICIADA);
        save(ordemServico);
    }

    /**
     * Muda o status de uma Ordem de Serviço para FINALIZADA. A Ordem de serviço que será alterada,
     * será a que possui o valor do id que está no objeto RequisicaoFinalizaOrdemServico.id.
     *
     * Também será possível setar os valores dos campos data de término e comentário, se preenchidos,
     * da Ordem de Serviço.
     *
     * @param requisicaoFinalizaOrdemServico
     */
    public void finalizaOrdemServico(RequisicaoFinalizaOrdemServico requisicaoFinalizaOrdemServico) {
        OrdemServico ordemServico = ordemServicoRepository.getById(Long.valueOf(requisicaoFinalizaOrdemServico.getId()));
        ordemServico.setDataTermino(AppUtil.getLocalDateTime(requisicaoFinalizaOrdemServico.getDataTermino()));
        ordemServico.setComentario(requisicaoFinalizaOrdemServico.getComentario());
        ordemServico.setStatus(StatusOrdemServico.FINALIZADA);
        save(ordemServico);
    }
}
