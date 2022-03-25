package com.efacture.dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.CptMarchand;
import com.efacture.dev.model.Facturier;

public interface FacturieRepository extends JpaRepository<Facturier, Long>{
	
	Optional<Facturier> findByName(String name);
}
