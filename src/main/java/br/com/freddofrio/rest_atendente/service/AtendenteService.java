package br.com.freddofrio.rest_atendente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.freddofrio.rest_atendente.domain.Atendente;
import br.com.freddofrio.rest_atendente.repository.AtendenteRepository;

@Service
public class AtendenteService {

    private final AtendenteRepository repository;

    @Autowired
    public AtendenteService(AtendenteRepository repository) {
        this.repository = repository;
    }
    
    public Page<Atendente> findAll10OrderBy(int page, int size, String orderBy, Long id) {
        Sort sort = Sort.by(orderBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.findAllByProprietarioId(pageable, id);
    }


    public Page<Atendente> findAll10(int page, int size, Long id) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByProprietarioId(pageable, id);
    }

    public Atendente save(Atendente atendente) {
        return repository.save(atendente);
    }

	public void delete(Long proprietarioId, Long id, String codigo) {
		
		Atendente atendente = 
				repository.findByIdAndCodigoAndProprietarioId(id, codigo, proprietarioId);
		
		repository.delete(atendente);
	}
}
