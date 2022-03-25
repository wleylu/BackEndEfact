package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.CompteMarchand;


/*import com.efacture.dev.exception.model.LoginExistException;
import com.efacture.dev.exception.model.LoginNonTrException;
import com.efacture.dev.model.UserAuditConnect;*/

//import java.util.List;

import com.efacture.dev.model.Utilisateur;

//import com.efact.domaine.UserEntity;

public interface UserService {
	//public List<UserEntity> userGetSerByStatus(String status);
	public Utilisateur utilisateurConnecte(String login);
	public Utilisateur getUser(String user);
	//public void ajoutAuditUser(UserAuditConnect userConect);
	public Utilisateur authentification(String login,String password);
	public Utilisateur firstAuthentification(Utilisateur userEntity);
	//public Utilisateur firstAuthentification(Utilisateur userEntity,String password1);
	//public Utilisateur firstAuthentification(String login, String password,String password1);
	public Utilisateur connexion(String login,String password1);
	//public UserEntity authentification(UserEntity userEntity);
	public void deconnexion(String login);
	public Utilisateur enregistrerUserEntity(Utilisateur userEntity);
	public List<Utilisateur> listeUserEntity();
	//public UserEntity listeUserEntity(UserEntity userEntity);
	public Utilisateur modifierUserEntity(Utilisateur userEntity);
	public String  getByUserByMail(String email);
	//public Utilisateur modifierMotDePasse(Utilisateur userEntity);
	public List<Utilisateur> rechercheByNom(String nom);
	public List<Utilisateur> rechercheByLogin(String login);
	 public List<Utilisateur> rechercheByNomAndLogin(String nom,String login);
	 public Utilisateur rechercheByEmail(String email);
	 public Utilisateur modifierMotDePasseEmail(String email);
	 public List<Utilisateur> listeUserProfilMarchand(String login);
	 public List<Utilisateur> listeUserProfilBackOffice();
		 
	// public Utilisateur modifierMotPasse(Utilisateur userEntity);
	/*
	 * public CptMarchand rechercheNumCptCm(String num_cpt_cm); public CptMarchand
	 * rechercheCptCmByLoginAndNumCptCm(String login,String num_cpt_cm);
	 */
}
