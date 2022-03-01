package br.com.freddofrio.rest_atendente.views.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.freddofrio.rest_atendente.domain.Atendente;
import br.com.freddofrio.rest_atendente.repository.AtendenteRepository;
import br.com.freddofrio.rest_atendente.service.AtendenteService;

@RestController
@RequestMapping("/atendente")
public class AtendenteRestController {

    private final AtendenteService service;

    @Autowired
    public AtendenteRestController(AtendenteService service) {
        this.service = service;
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Iterable list10(
    		@PathVariable(name = "id") Long proprietarioId,
    		@RequestParam(name = "page") Integer page,
    		@RequestParam(name = "size") Integer size, 
    		@RequestParam(name = "orderBy", required = false) String orderBy
    ) {
        if (orderBy != null) {
        	Page<Atendente> atendent = service.findAll10OrderBy(page, size, orderBy, proprietarioId);
        	return atendent;
        } else {
        	Page<Atendente> atendentes = service.findAll10(page, size, proprietarioId);
            return atendentes;
        }
    }
    
    @DeleteMapping("/{proprietarioId}/{id}")
    public @ResponseBody String delete(
    		@PathVariable("proprietarioId") Long proprietarioId, 
    		@PathVariable("id") Long id, 
    		@RequestParam("codigo") String codigo) {
    	
    	service.delete(proprietarioId, id, codigo);
    	
    	return "OK";
    }

    @PostMapping
    public Atendente postAtendente(@Valid @RequestBody Atendente atendente, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        Atendente result = service.save(atendente);
        
        return result;
    }
}