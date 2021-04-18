package com.controladorvacina.controladorvacinaapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.controladorvacina.controladorvacinaapi.model.Vacina;
import com.controladorvacina.controladorvacinaapi.repository.VacinaRepository;


@RestController
@RequestMapping("/vacinas")
public class VacinaController {

	@Autowired
	private VacinaRepository vacinaRepository;
	
	@GetMapping
	public List<Vacina> listar() {
		return vacinaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacina adicionar(@RequestBody Vacina vacina) {
		return vacinaRepository.save(vacina);
	}
}
