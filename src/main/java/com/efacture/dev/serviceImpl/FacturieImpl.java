package com.efacture.dev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.FacturieRepository;
import com.efacture.dev.service.ServiceFacturier;

@Service
public class FacturieImpl implements ServiceFacturier {
	@Autowired
	private FacturieRepository facturieRepository;

	/*
	 * @Override public Facturier getListFacture(String intituleFacturier, String
	 * identFacture) { // TODO Auto-generated method stub return
	 * facturieRepository.findByIntituleFactAndIdentfact(intituleFacturier,
	 * identFacture); }
	 */
	/*
	 * @Override public List<Facturier> getListFacture(String identifiant) { // TODO
	 * Auto-generated method stub return
	 * facturieRepository.findByIdentifiant(identifiant); }
	 */

	/*
	 * @Override public List<Facturier> listeFactureEntity() { // TODO
	 * Auto-generated method stub return null; }
	 */

	//@SuppressWarnings("unchecked")
	//@Override
//	public List<Facturier> listeFacture(String identifiant) {		
//		return facturieRepository.findByIdentifiant(identifiant);
//	}

	
	
}
 