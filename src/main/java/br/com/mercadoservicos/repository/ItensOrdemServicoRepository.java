package br.com.mercadoservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadoservicos.domain.ItensOrdemServico;

@Repository
public interface ItensOrdemServicoRepository extends JpaRepository<ItensOrdemServico, Integer>{

}
