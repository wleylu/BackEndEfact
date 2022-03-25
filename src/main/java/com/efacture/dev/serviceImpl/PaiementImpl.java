package com.efacture.dev.serviceImpl;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Paiement;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.PaieRepository;
import com.efacture.dev.service.ServicePaie;

@Service
public class PaiementImpl implements ServicePaie {

	@Autowired
	private PaieRepository paieRepository;

	// @Override
	/*
	 * public Paiement effectuerPaie(String numCpt, String montantFacture, String
	 * intituleFacturier, long frais, long timbre) { Paiement paiement = new
	 * Paiement(); paiement.setNumCpt(numCpt);
	 * paiement.setMontantFacture(montantFacture);
	 * paiement.setIntituleFacturier(intituleFacturier); paiement.setFrais(frais);
	 * paiement.setTimbre(timbre); paiement.set; return
	 * paieRepository.save(paiement);
	 * 
	 * }
	 */
	public String generateRef() {
		return "ref" + RandomStringUtils.randomNumeric(10);
	}

	private String generateCode() {
		return "code" + RandomStringUtils.randomNumeric(10);
	}

	/*
	 * @Override public Paiement effectuerPaie(String numCpt, String montantFacture,
	 * String intituleFacturier, long frais, long timbre) { Paiement paiement = new
	 * Paiement(); paiement.setNumCpt(numCpt);
	 * paiement.setMontantFacture(montantFacture);
	 * paiement.setIntituleFacturier(intituleFacturier); paiement.setFrais(frais);
	 * paiement.setTimbre(timbre); paiement.setReference(generateRef());
	 * paiement.setCodeReponse(generateCode()); return
	 * paieRepository.save(paiement); }
	 */
	@Override
	public Paiement findByNumCpt(String numCpt) {
		return paieRepository.findByNumCpt(numCpt);
	}

	/*
	 * @Override public Paiement effectuerPaie(Paiement paiement) { Paiement paie =
	 * new Paiement(); return paieRepository.save(paie); }
	 */
	@Override
	public Paiement retourPayement(String numCpt) {
		// TODO Auto-generated method stub
		return paieRepository.findByNumCpt(numCpt);
	}

	@Override
	public Paiement effectuerPaie(String numCpt, long montantFacture, String intituleFacturier, long frais, long timbre,
			String identifiant, long montantPaye, Date datePaiement, String typePaye, String codeReponse) {
		Utilisateur user = new Utilisateur();
		Paiement paie = new Paiement();
		paie.setNumCpt(numCpt);
		paie.setMontantFacture(montantFacture);
		paie.setIntituleFacturier(intituleFacturier);
		paie.setFrais(frais);
		paie.setTimbre(timbre);
		paie.setReference(generateRef());
		paie.setCodeReponse(generateCode());
		paie.setIdentifiant(identifiant);
		paie.setMontantPaye(montantPaye);
		paie.setDatePaiement(datePaiement);
		paie.setTypePaye(typePaye);

		paieRepository.save(paie);
		return paie;
	}

}
