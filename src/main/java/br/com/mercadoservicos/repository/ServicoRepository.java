package br.com.mercadoservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadoservicos.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
