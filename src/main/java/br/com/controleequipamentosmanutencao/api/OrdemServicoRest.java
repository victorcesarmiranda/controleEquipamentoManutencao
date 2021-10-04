package br.com.controleequipamentosmanutencao.api;

import br.com.controleequipamentosmanutencao.dto.RequisicaoFinalizaOrdemServico;
import br.com.controleequipamentosmanutencao.dto.RequisicaoIniciaOrdemServico;
import br.com.controleequipamentosmanutencao.dto.RequisicaoNovaOrdemServico;
import br.com.controleequipamentosmanutencao.enums.StatusOrdemServico;
import br.com.controleequipamentosmanutencao.model.OrdemServico;
import br.com.controleequipamentosmanutencao.response.OrdensServicoResponse;
import br.com.controleequipamentosmanutencao.service.OrdemServicoService;
import br.com.controleequipamentosmanutencao.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/ordemservico")
public class OrdemServicoRest {

    @Autowired
    OrdemServicoService ordemServicoService;

    @PostMapping
    public OrdemServico cadastraOrdemServico(@Valid @RequestBody RequisicaoNovaOrdemServico requisicaoNovaOrdemServico) {

        OrdemServico ordemServico = ordemServicoService.criaOrdemServico(requisicaoNovaOrdemServico);
        ordemServicoService.save(ordemServico);

        return ordemServico;
    }

    @GetMapping
    public List<OrdensServicoResponse> getUltimasOrdensServico() {
        List<OrdensServicoResponse> ordensServicoResponse = new ArrayList<>();
        ordemServicoService.findDezUltimasOrdensServico().forEach(ordemServico -> ordensServicoResponse
                .add(OrdensServicoResponse
                        .builder()
                        .status(ordemServico.getStatus().name())
                        .nomePeca(ordemServico.getPeca().getNome())
                        .tipoPeca(ordemServico.getPeca().getTipo())
                        .marcaPeca(ordemServico.getPeca().getMarca())
                        .nomeCliente(ordemServico.getCliente().getNome())
                        .dataCadastro(AppUtil.formataData(ordemServico.getDataCadastro()))
                        .build()));

        return ordensServicoResponse;
    }

    @GetMapping("/{status}")
    public List<OrdensServicoResponse> getOrdensServicoByStatus(@PathVariable String status) {
        List<OrdensServicoResponse> ordensServicoResponse = new ArrayList<>();
        ordemServicoService.findAllByStatus(StatusOrdemServico.valueOf(status.toUpperCase())).forEach(ordemServico -> ordensServicoResponse
                .add(OrdensServicoResponse
                        .builder()
                        .id(ordemServico.getId().toString())
                        .status(ordemServico.getStatus().name())
                        .nomePeca(ordemServico.getPeca().getNome())
                        .tipoPeca(ordemServico.getPeca().getTipo())
                        .marcaPeca(ordemServico.getPeca().getMarca())
                        .nomeCliente(ordemServico.getCliente().getNome())
                        .dataInicio(Objects.toString(ordemServico.getDataInicio(), null))
                        .dataTermino(Objects.toString(ordemServico.getDataTermino(), null))
                        .dataCadastro(AppUtil.formataData(ordemServico.getDataCadastro()))
                        .descricao(ordemServico.getDescricao())
                        .comentario(ordemServico.getComentario())
                        .build()));

        return ordensServicoResponse;
    }

    @PostMapping("/iniciar")
    public void iniciar (@Valid @RequestBody RequisicaoIniciaOrdemServico requisicaoIniciaOrdemServico) {
        ordemServicoService.iniciaOrdemServico(requisicaoIniciaOrdemServico);
    }

    @PostMapping("/finalizar")
    public void finalizar (@Valid @RequestBody RequisicaoFinalizaOrdemServico requisicaoIniciaOrdemServico) {
        ordemServicoService.finalizaOrdemServico(requisicaoIniciaOrdemServico);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar (@PathVariable Long id) {
        ordemServicoService.deleteById(id);
    }

    @GetMapping("/peca/{id}")
    public OrdensServicoResponse getOrdemServicoId(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoService.findOrdemServicoId(id);
        return OrdensServicoResponse.builder()
                .id(ordemServico.getId().toString())
                .nomePeca(ordemServico.getPeca().getNome())
                .marcaPeca(ordemServico.getPeca().getMarca())
                .tipoPeca(ordemServico.getPeca().getTipo())
                .build();
    }

}
