package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import com.efacture.dev.model.Compte;

import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.Consultation;

public interface CompteRepository extends JpaRepository<Comptes, String> {
	public Comptes findByCompte(String cpt);

//public List<Comptes> findByCompteMarchand(String code);
	public List<Comptes> findByCompteMarchand(CompteMarchand compteMarchand);
	public List<Comptes> findByCompteMarchand(String compteMarchand);
//public Comptes findByCompteMarchand(String );

// @Query("select compte from Compte compte join compte.CompteMarchand CompteMarchand where CompteMarchand.code = :code")
// public List<Compte> FindAllCompte(@Param("code") Long code);
//public List<Compte> findByNom(String nom);
//@Query("SELECT c.compteMarchand FROM Compte c WHERE c.compteMarchand.Code = :Code")
//public List<Compte> findByCompteMarchand(@Param("Code") Long Code);
//@Query("SELECT new com.efacture.dev.model.Compte.CompteClientDto(cm.nom, c.compte) "
// + "FROM CompteMarchand cm INNER JOIN cm.compte c")
// List<CompteClientDto> fetchCompteClientDataInnerJoin();
//@Query("SELECT c.compteMarchand FROM Compte c")
	/*
	 * @Query("SELECT c FROM Compte c") public List<Compte> findByComptes();
	 *
	 * @Query("SELECT c FROM Compte c JOIN FETCH c.compteMarchand cm WHERE c.id = cm.compte"
	 * ) List<Compte> findAll();
	 */
//public Compte findByNumCompte(String cpt);
//public List<Compte> findByCompteMarchand(Long id);
//@Query("FROM Compte AS rdt WHERE c.rdt.code.id = ?1") //This is using a named query method
//public List<Compte> FindAllWithDescriptionQuery(Long id);
//@Query("SELECT c FROM Compte c WHERE c.numCompte = :x")
//public Compte getCompte(@Param("x") String code);
//
	@Query(value = "SELECT * FROM comptes WHERE code= ?1 AND statut= 1", nativeQuery = true)
	public List<Comptes>  findByCodeAndStatut(String code);
}