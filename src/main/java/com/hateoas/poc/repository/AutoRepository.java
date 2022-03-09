package com.hateoas.poc.repository;

import com.hateoas.poc.model.Auto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {


     List<Auto> findByAgenciaId(Long id);


     @Query(value = "SELECT * FROM AUTO WHERE auto.agencia_id = ?1  LIMIT ?2 OFFSET ?3", nativeQuery = true)
     List<Auto> findByAgenciaIdAndMore(Long id, int limit, int offset);


    Page<Auto> findAllByAgenciaId ( Long id, Pageable pageable);
}