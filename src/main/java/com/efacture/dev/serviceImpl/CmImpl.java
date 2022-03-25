package com.efacture.dev.serviceImpl;

 

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Commission;
//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.ErreurGenere;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.CmRepository;
import com.efacture.dev.repository.CommissionRepository;
import com.efacture.dev.repository.CompteRepository;
import com.efacture.dev.service.ServiceCm;

@Service
@Transactional
public class CmImpl implements ServiceCm {
	
	@Autowired
	private UserServiceImpl user; 
	
    
	@Autowired
    private CmRepository cmRepository;
	@Autowired
	private ErreurGenereImpl erreurGenereImpl;
    @Autowired
    private CommissionRepository reposistoryCommission;
    
    @Autowired
    private CompteRepository compte;

    public CompteMarchand ajouterCm(CompteMarchand c) {
		Commission com = reposistoryCommission.findById(c.getCommission().getIdCommission()).get();
		Comptes cpt = null;     //c.getComptes().get(0);
		CompteMarchand marchand = new CompteMarchand();
		CompteMarchand march = new CompteMarchand();
		Utilisateur userLogin = user.getUser(c.getLoginAdd()) ;
		
		try {
			if (cmRepository.findByClient(c.getClient()) == null && cmRepository.findByEmail(c.getEmail())==null
					&& cmRepository.findByTel(c.getTel())==null){
				marchand.setClient(c.getClient());
				marchand.setSexe(c.getSexe());
				marchand.setNomPrenom(c.getNomPrenom());
				marchand.setNom(c.getNom());
				marchand.setPrenom(c.getPrenom());
				marchand.setDateNais(c.getDateNais());
				marchand.setStatut(c.getStatut());
				marchand.setTypeCpt(c.getTypeCpt());
				marchand.setNumCpt(c.getSexe());
				marchand.setNumCptContribuable(c.getNumCptContribuable());
				marchand.setRegCrc(c.getRegCrc());
				marchand.setOptionCm(c.getOptionCm());
				marchand.setRaisonSocial(c.getRaisonSocial());
				marchand.setAgec(c.getAgec());
				marchand.setTel(c.getTel());
				marchand.setPieceId(c.getPieceId());
				marchand.setDateExpir(c.getDateExpir());
				marchand.setDateDelivr(c.getDateDelivr());
				marchand.setEmail(c.getEmail());
				marchand.setLogin(c.getLogin());
				marchand.setAdCm(c.getAdCm());
				marchand.setDateModification(c.getDateModification());
				marchand.setCommission(com);
				marchand.setLoginAdd(c.getLoginAdd());
				marchand.setLoginModification(c.getLoginModification());
				march=cmRepository.save(marchand);
				
						if (march != null) {
							for(Comptes cp:c.getComptes()){
								cpt = new Comptes(cp.getCompte(), 
										cp.getAgence(), cp.getNcg(), 
										cp.getLibNcg(), cp.getCoddci(), cp.getExpl(), cp.getStatut(), marchand);
								compte.save(cpt);
							}
								Utilisateur utilisateur = new Utilisateur();
								utilisateur.setLogin(march.getClient());
								utilisateur.setClient(march.getClient());
								utilisateur.setAgence(userLogin.getAgence());
								utilisateur.setFiliale(userLogin.getFiliale());
								utilisateur.setHabilitation("ROLE_USER_PERSO");
								utilisateur.setTel(march.getTel());
								utilisateur.setEmail(march.getEmail());
								utilisateur.setNom(march.getNom());
								utilisateur.setPrenom(march.getPrenom());
								utilisateur.setTypePlafond(1);
								utilisateur.setTypeComfirmation(2);
								utilisateur.setLoginAdd(userLogin.getLogin());
								utilisateur.setLoginMaj(userLogin.getLogin());
								Utilisateur uti = user.enregistrerUserEntity(utilisateur);
								System.out.println("utilisateur ajouté : "+uti.getClient());
						
						}
					System.out.println("Marchand : "+march.getClient());
					
				//cpt.setCompteMarchand(marchand);
				return march;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
	}

    @Override
    public List<CompteMarchand> listMarchands() {
    	try {
    		return cmRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
        
        
    }
    
    @Override
    public CompteMarchand getMarchand(String client) {
    	try {
    		CompteMarchand compteMarchand = cmRepository.findById(client).get();
			if (compteMarchand != null) {
		        return compteMarchand;
			} else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
    }

	@Override
	public CompteMarchand modifierCm(CompteMarchand cptMarchand) {
		cptMarchand.setDateModification(new Date(System.currentTimeMillis()));
		CompteMarchand marchands = new CompteMarchand();
		
		try {
			CompteMarchand cpt = cmRepository.findByClient(cptMarchand.getClient());
			//Utilisateur uti = user.getUser(cptMarchand.getLoginModification());
			if (cpt!=null) {
		
				return cmRepository.save(cptMarchand);
			}else {
			
				return marchands;
			}
		} catch (Exception e) {
			return marchands;
		}
		
		
		
	}

	@Override
	public List<CompteMarchand> rechercheByNomAndLogin(String nom, String login) {
		try {
			return cmRepository.findByNomContainingIgnoreCaseAndLoginContainingIgnoreCase(nom, login);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<CompteMarchand> rechercheByLogin(String login) {
		try {
			return cmRepository.findByLogin(login);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

	@Override
	public CompteMarchand getByEmail(String email) {
		CompteMarchand existeEmail=cmRepository.findByEmail(email);
		try {
			if (existeEmail != null) {
				return existeEmail;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
	}
	public CompteMarchand getByTel(String tel) {
		CompteMarchand existeTel=cmRepository.findByTel(tel);
		try {
			if (existeTel != null) {
				return existeTel;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
	}

	@Override
	public String getByMarchandByMail(String email) {
		try {
			return cmRepository.getByMarchandByMail(email);
		} catch (Exception e) {
			return null;
		}
		
	}
    
}