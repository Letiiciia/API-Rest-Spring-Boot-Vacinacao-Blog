package com.controladorvacina.controladorvacinaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controladorvacina.controladorvacinaapi.model.Usuario;

@Repository
public interface VacinaRepository extends JpaRepository<Usuario, Long>{

}
