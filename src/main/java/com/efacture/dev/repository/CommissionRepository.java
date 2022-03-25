package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CompteMarchand;

public interface CommissionRepository extends JpaRepository<Commission, Long>  {
	public Commission findByIdCommission(Long id);
	//public List<Commission> findByLibelle(String libelle);
	public List<Commission> FacturierContainingIgnoreCaseAndLibelleContainingIgnoreCase(String facturier,String libelle);
	public List<Commission> findByCommissionFacturierContaining(Long commissionFacturier);
}
