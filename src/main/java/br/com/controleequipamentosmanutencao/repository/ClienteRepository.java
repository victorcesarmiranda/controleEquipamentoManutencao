package br.com.controleequipamentosmanutencao.repository;

import br.com.controleequipamentosmanutencao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
