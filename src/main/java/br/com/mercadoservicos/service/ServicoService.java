package br.com.mercadoservicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.repository.ServicoRepository;
import br.com.mercadoservicos.service.exception.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> findAll(){
		return servicoRepository.findAll();
	}
	
	public Servico findById(Integer id){
		Optional<Servico> servico = servicoRepository.findById(id);
		return servico.orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado"));
	}
	
	public Servico insert(Servico servico){
		servico.setId(null);
		return servicoRepository.save(servico);
	}
	
	public Servico update(Servico servico, Integer id) {
		servico.setId(id);
		return servicoRepository.save(servico);
	}
	
	public void delete(Integer id) {
		servicoRepository.deleteById(id);
	}
	
}
