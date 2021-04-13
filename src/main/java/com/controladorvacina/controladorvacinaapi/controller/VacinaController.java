package com.controladorvacina.controladorvacinaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controladorvacina.controladorvacinaapi.model.Vacina;
import com.controladorvacina.controladorvacinaapi.repository.VacinaRepository;


@RestController
@RequestMapping("/vacinas")
public class VacinaController {

	@Autowired
	private VacinaRepository vacinaRepository;
	
	public List<Vacina> listar() {
		return vacinaRepository.findAll();
	}
}
