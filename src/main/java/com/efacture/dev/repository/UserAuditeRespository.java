package com.efacture.dev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.CptMarchand;
import com.efacture.dev.model.UserAudite;
import com.efacture.dev.model.Utilisateur;

public interface UserAuditeRespository extends JpaRepository<UserAudite, Long> {
	public List<UserAudite> findByLoginContaining(String login);
	public List<UserAudite> findByStatutContaining(String Statut);
	public List<UserAudite> findByDateBetween(Date firstDate,Date lastDate);
	public List<UserAudite> findByDateContaining(Date firstDate);
	public List<UserAudite> findByDateBetweenAndLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndRoleContainingIgnoreCaseAndStatutContainingIgnoreCase(Date firstDate,Date lastDate,String login,String nom,String role,String statut);
	public List<UserAudite> findByLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndRoleContainingIgnoreCaseAndStatutContainingIgnoreCase(String login,String nom,String role,String statut);
	//public UserAudite findByDateConnexionAndDateDeconnexion(String dateConnexionAnd,String dateDeconnexion);
}
