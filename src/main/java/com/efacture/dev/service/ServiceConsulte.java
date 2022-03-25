package com.efacture.dev.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Paiement;

//import com.efacture.dev.model.CptMarchand;

public interface ServiceConsulte {
	public List <Consultation> consultePaie(String login);
	//public  Consultation consultePaieId(Long id);
	public Optional<Consultation> recherche(Long id);
	public Consultation rechercheConsulteByFacturier(String facturier);
	public Consultation rechercheConsulteByref(String reference);
	public Integer compteur(String login,java.sql.Date date_regle);
	public Integer compteurMtn(String login,java.sql.Date date_regle);
//	public Consultation rechercheConsulteByFactAndRef(String facturier,String reference);
//	public List<Consultation> listeConsultation();
	
	public Consultation vueConsultation(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, String dtExpFacture, String reference, String referenceFT, String identifiant, String login,Date heure, String filiale);
	public List <Consultation> listHistorique();
	
//	public List<Consultation>listeConsultation(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, Date dtExpFacture);
	public List <Consultation> recherches(String login,String referenceFt,String facturier,String identifiant,String dtExpFacture,long montantDebite);
	public List <Consultation> rechercheTransaction(Date firstDate,Date lastDate,String login,String referenceFt,String facturier,String identifiant);
	public List <Consultation> rechercheByreferenceFt(String referenceFt);
	public List <Consultation> rechercheByfacturier(String facturier);
	public  Consultation rechercheByFiliale(String filiale);
	public List <Consultation> rechercheByidentifiant(String identifiant);
	public List <Consultation> rechercheBydtExpFacture(String dtExpFacture);
	public List <Consultation> rechercheBymontantDebite(long montantDebite);
	public List <Consultation> recherche(String login,String referenceFt,String facturier,String identifiant);
	//public Consultation consultePaieId(Long id);
	// public Consultation rechercheConsulteByFactAndRef(String facturier,String reference);
	// public List<Consultation> listeConsultation();
	
	// public List<Consultation>listeConsultation(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, Date dtExpFacture);
	public List<Consultation> rechercheByPeriode(Date dat1,Date dat2);
}
