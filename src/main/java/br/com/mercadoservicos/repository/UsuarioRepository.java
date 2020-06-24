package br.com.mercadoservicos.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadoservicos.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findByTipo(String tipo);
	
	public List<Usuario> findByDataNascimentoGreaterThan(Date data);
	
	public List<Usuario> findByDataNascimentoBetween(Date dataInicial, Date dataFinal);
}
