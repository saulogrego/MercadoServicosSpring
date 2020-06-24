package br.com.mercadoservicos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findByEmail(@RequestParam(value="email") String email){
		Usuario usuario = usuarioService.findByEmail(email);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/tipo", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findByTipo(@RequestParam(value="tipo") String tipo){
		List<Usuario> usuarios = usuarioService.findByTipo(tipo);
		return ResponseEntity.ok().body(usuarios);
	}
	
	@RequestMapping(value="/dataNascimento", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findByDataNascimento(){
		List<Usuario> usuarios = usuarioService.findByDataNascimento();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		usuario.setId(null);
		usuario = usuarioService.insert(usuario);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(usuario.getId())
					.toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		usuario = usuarioService.update(usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
