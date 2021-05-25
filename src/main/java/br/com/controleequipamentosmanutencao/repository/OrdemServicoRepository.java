package br.com.controleequipamentosmanutencao.repository;

import br.com.controleequipamentosmanutencao.enums.StatusOrdemServico;
import br.com.controleequipamentosmanutencao.model.OrdemServico;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    List<OrdemServico> findAllByStatus(StatusOrdemServico status, Pageable page);
}
