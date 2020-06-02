package br.com.mercadoservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadoservicos.domain.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {

}
