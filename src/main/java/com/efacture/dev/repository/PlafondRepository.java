package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Plafond;
import com.efacture.dev.model.TypePaiement;
import com.efacture.dev.model.Utilisateur;

public interface PlafondRepository extends JpaRepository<Plafond, Long> {
	public List<Plafond> findByTypePlafondOrderByIdPlafondDesc(int type);
	public Plafond findByNombreFactureAndMontantMax(long NombreFacture,long MontantMax);
	public Plafond findByTypePlafond(int type);
}
