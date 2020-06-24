package br.com.mercadoservicos;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.repository.CategoriaRepository;
import br.com.mercadoservicos.repository.ServicoRepository;
import br.com.mercadoservicos.repository.UsuarioRepository;

@SpringBootApplication
public class MercadoServicosApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MercadoServicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(1, "Informática");
		Categoria c2 = new Categoria(2, "Limpeza");
		Categoria c3 = new Categoria(3, "Automóveis");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Servico s1 = new Servico(1, "Formatação", 100.0, c1);
		Servico s2 = new Servico(2, "Ar Condicionado", 200.0, c2);
		Servico s3 = new Servico(3, "Alinhamento", 50.0, c3);
		Servico s4 = new Servico(4, "Balanceamento", 30.0, c3);

		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		Usuario u1 = new Usuario(1, "João da Silva", "joaosilva@gmail.com", "123456", "F", "111.111.111-11", null, new Date(1990,3,12));
		Usuario u2 = new Usuario(2, "Loja de Informática do João", "lojainformatica@gmail.com", "123456", "J", null, "11.111.111/1111-11", null);
		Usuario u3 = new Usuario(3, "Maria José", "mariajose@gmail.com", "123456", "F", "111.111.111-11", null, new Date(1975,8,31));
		Usuario u4 = new Usuario(4, "Oficina da Maria José", "oficinamariajose@gmail.com", "123456", "J", null, "11.111.111/1111-11", null);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
	}
}
