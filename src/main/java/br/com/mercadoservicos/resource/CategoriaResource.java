package br.com.mercadoservicos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Categoria> insert(@RequestBody Categoria categoria) {
		categoria.setId(null);
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(categoria.getId())
					.toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
		categoria.setId(id);
		categoria = categoriaService.update(categoria);
		return ResponseEntity.ok().body(categoria);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
