package br.com.mercadoservicos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.repository.UsuarioRepository;
import br.com.mercadoservicos.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public Usuario findByEmail(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public List<Usuario> findByTipo(String tipo) {
		List<Usuario> usuarios = usuarioRepository.findByTipo(tipo);
		return usuarios;
	}
	
	public List<Usuario> findByDataNascimento(){
		List<Usuario> usuarios = usuarioRepository.findByDataNascimentoGreaterThan(new Date(1980,1,1));
		return usuarios;
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
