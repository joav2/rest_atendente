package br.com.freddofrio.rest_atendente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.freddofrio.rest_atendente.domain.Atendente;
import br.com.freddofrio.rest_atendente.repository.AtendenteRepository;
import br.com.freddofrio.rest_atendente.service.AtendenteService;

@SpringBootApplication
public class RestAtendenteApplication implements CommandLineRunner{
	
	@Autowired
	private AtendenteRepository repository;
	
	@Autowired
	private AtendenteService service;

	public static void main(String[] args) {
		SpringApplication.run(RestAtendenteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Atendente atendente = repository.findByIdAndCodigoAndProprietarioId(5L, "2d6LTr", 6L);
//		
//		repository.delete(atendente);
	}
}
