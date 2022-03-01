package br.com.freddofrio.rest_atendente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.freddofrio.rest_atendente.domain.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {

    Page<Atendente> findAllByProprietarioId(Pageable pageable, Long id);
    
    Atendente findByIdAndCodigoAndProprietarioId(Long id, String codigo, Long proprietarioId);
}
