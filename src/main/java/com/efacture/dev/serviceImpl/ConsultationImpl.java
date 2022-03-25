package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Consultation;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Paiement;
import com.efacture.dev.model.Utilisateur;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.repository.ConsulteRepository;
//import com.efacture.dev.repository.FacturieRepository;
import com.efacture.dev.service.ServiceConsulte;

//import com.efacture.dev.service.ServiceFacturier;
@Service
public class ConsultationImpl implements ServiceConsulte {
	@Autowired
	private ConsulteRepository consulteRepository;

	/*
	 * @Override public ServiceConsulte consultation(String intituleFacturier,
	 * String identFacture) { return
	 * facturieRepository.findByIntituleFactAndIdentfact(intituleFacturier,
	 * identFacture); }
	 */
	@Override
	public List<Consultation> consultePaie(String login) {
		return consulteRepository.findByLogin(login);

	}

	@Override
	public Consultation rechercheConsulteByFacturier(String facturier) {
		// TODO Auto-generated method stub
		return consulteRepository.findByFacturier(facturier);
	}

	@Override
	public Consultation rechercheConsulteByref(String reference) {
		// TODO Auto-generated method stub
		return consulteRepository.findByReference(reference);
	}
	
	@Override
	public Optional<Consultation> recherche(Long id) {
		// TODO Auto-generated method stub
		return consulteRepository.findById(id);
	}

	@Override
	public List<Consultation> listHistorique() {
		return consulteRepository.findAll();
	}
//	@Override
//	public Consultation rechercheConsulteByFactAndRef(String facturier, String reference) {
//		// TODO Auto-generated method stub
//		return consulteRepository.findByReferenceAndFacturier(reference, facturier);
//	}

	@Override
	public Consultation vueConsultation(Date dateRegle, long montantDebite, String numCpt, String typeRegle,
			String facturier, String dtExpFacture, String reference, String referenceFT, String identifiant, String login, Date heure, String filiale) {
		Consultation cons = new Consultation();
		cons.setDateRegle(dateRegle);
		cons.setMontantDebite(montantDebite);
		cons.setNumCpt(numCpt);
		cons.setTypeRegle(typeRegle);
		cons.setFacturier(facturier);
		cons.setDtExpFacture(dtExpFacture);
		cons.setReference(reference);
		cons.setReferenceFT(referenceFT);
		cons.setIdentifiant(identifiant);
		cons.setLogin(login);
		cons.setHeure(heure);
		cons.setFiliale(filiale);
		consulteRepository.save(cons);
		return cons;
	}
	
	
	// @Override
	// public Consultation rechercheConsulteByFactAndRef(String facturier, String reference) {
	// // TODO Auto-generated method stub
	// return consulteRepository.findByReferenceAndFacturier(reference, facturier);
	// } @Override
		@Override
		public List<Consultation> rechercheByPeriode(Date dat1, Date dat2) {
			// TODO Auto-generated method stub
			return consulteRepository.findByDateRegleBetween(dat1, dat2);
		}
		@Override
		public List<Consultation> recherches(String login, String referenceFt, String facturier, String identifiant,
				String dtExpFacture, long montantDebite) {
			return null;
				}
		@Override
		public List<Consultation> rechercheTransaction(Date firstDate,Date lastDate,String login,String referenceFt,String facturier,String identifiant){
			// TODO Auto-generated method stub
			try {
				return consulteRepository.findByDateRegleBetweenAndLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase(firstDate, lastDate,login,referenceFt, facturier, identifiant);
			} catch (Exception e) {
				return new ArrayList<>();
			}
		}
		@Override
		public List<Consultation> rechercheByreferenceFt(String referenceFt) {
			// TODO Auto-generated method stub
			return consulteRepository.findByReferenceFTContaining(referenceFt);
		}
		@Override
		public List<Consultation> rechercheByfacturier(String facturier) {
			// TODO Auto-generated method stub
			return consulteRepository.findByFacturierContaining(facturier);
		}
		@Override
		public List<Consultation> rechercheByidentifiant(String identifiant) {
			// TODO Auto-generated method stub
			return consulteRepository.findByIdentifiantContaining(identifiant);
		}
		@Override
		public List<Consultation> rechercheBydtExpFacture(String dtExpFacture) {
			// TODO Auto-generated method stub
			return consulteRepository.findByDtExpFactureContaining(dtExpFacture);
		}
		@Override
		public List<Consultation> rechercheBymontantDebite(long montantDebite) {
			// TODO Auto-generated method stub
			return consulteRepository.findByMontantDebiteContaining(montantDebite);
		}

		@Override
		public Integer compteur(String login,java.sql.Date date_regle) {
			// TODO Auto-generated method stub
			return consulteRepository.findByLoginCpt(login,date_regle);
		}

		@Override
		public Integer compteurMtn(String login, java.sql.Date date_regle) {
			// TODO Auto-generated method stub
			System.out.println("DATE REG" + date_regle);
			return consulteRepository.findByLoginMtn(login, date_regle);
		}

		@Override
		public List<Consultation> recherche(String login, String referenceFt, String facturier, String identifiant) {
			try {
				return consulteRepository.findByLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase(login, referenceFt, facturier, identifiant);
						
			} catch (Exception e) {
				return new ArrayList<>();
			}
		}

		@Override
		public Consultation rechercheByFiliale(String filiale) {
			// TODO Auto-generated method stub
			return consulteRepository.findByFilialeContaining(filiale);
		}
	
		
}
