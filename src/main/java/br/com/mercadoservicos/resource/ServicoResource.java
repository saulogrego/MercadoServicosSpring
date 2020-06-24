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

import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.service.ServicoService;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
	
	@Autowired
	private ServicoService servicoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Servico>> findAll(){
		List<Servico> list = servicoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Servico> findById(@PathVariable Integer id){
		Servico servico = servicoService.findById(id);
		return ResponseEntity.ok().body(servico);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Servico> insert(@RequestBody Servico servico){
		servico = servicoService.insert(servico);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(servico.getId())
				.toUri();
		return ResponseEntity.created(uri).body(servico);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody Servico servico){
		servico = servicoService.update(servico, id);
		return ResponseEntity.ok().body(servico);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		servicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
