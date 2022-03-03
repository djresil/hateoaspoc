package com.hateoas.poc.repository;

import com.hateoas.poc.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaAutosRepository extends JpaRepository<Agencia, Long> {
}
