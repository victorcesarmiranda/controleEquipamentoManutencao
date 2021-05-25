package br.com.controleequipamentosmanutencao.repository;

import br.com.controleequipamentosmanutencao.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

}
