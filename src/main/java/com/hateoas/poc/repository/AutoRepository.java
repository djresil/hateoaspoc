package com.hateoas.poc.repository;

import com.hateoas.poc.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {


     List<Auto> findByAgenciaId(Long id);
}
