package com.efacture.dev.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.UserAudite;

public interface ConsulteRepository extends JpaRepository<Consultation, Long>{
	public List<Consultation> findByLogin(String login);
	public Consultation findByFacturier(String facturier);
	public Consultation findByReference(String reference);
	public Consultation findByReferenceAndFacturier(String reference, String facturier);
//	public List<Consultation> findBy(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, Date dtExpFacture);
	public List<Consultation> findByLoginContaining(String login);
	public List<Consultation> findByReferenceFTContaining(String referenceFt);
	public List<Consultation> findByFacturierContaining(String facturier);
	public Consultation findByFilialeContaining(String filiale);
	public List<Consultation> findByIdentifiantContaining(String identifiant);
	public List<Consultation> findByDtExpFactureContaining(String dtExpFacture);
	public List<Consultation> findByMontantDebiteContaining(long montantDebite);
	public List<Consultation> 
	findByLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase
	(String login,String referenceFt,String facturier,String identifiant);
	public List<Consultation> 
	findByDateRegleBetweenAndLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase(java.util.Date firstDate,java.util.Date lastDate,String login,String referenceFt,String facturier,String identifiant);
	// public List<Consultation> findBy(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, Date dtExpFacture);
	
	//@Query(value="SELECT * FROM consultation WHERE dateRegle  BETWEEN ? AND ?", nativeQuery =true)
	//public List<Consultation> rechercheByDate(@Param("dat1")Date dat1, @Param("dat2")Date dat2);
//	@Query(value="SELECT COUNT(*),date_regle,login FROM consultation WHERE login = ?1 GROUP BY login AND date_regle",nativeQuery=true)
//	Consultation findByLoginCpt(String login);
//	@Query(value = "SELECT COUNT(login) FROM consultation WHERE login= ?1 AND date_regle= ?2 GROUP BY login", nativeQuery = true)
//	public Integer findByLoginCpt(String login,Date date_regle);
//	@Query(value = "SELECT SUM(montant_debite) FROM consultation WHERE login = ?1 AND date_regle=?2 GROUP BY login", nativeQuery = true)
//	public Integer findByLoginMtn(String login,Date date_regle);
	@Query(value = "SELECT COUNT(login) FROM consultation WHERE login= ?1 AND date_regle= ?2", nativeQuery = true)
	public Integer findByLoginCpt(String login,java.sql.Date date_regle);
	@Query(value = "SELECT COALESCE (SUM(montant_debite),0) FROM consultation WHERE login = ?1 AND date_regle=?2", nativeQuery = true)
	public Integer findByLoginMtn(String login,java.sql.Date date_regle);
	List<Consultation> findByLoginAndDateRegleBetween(String login, Date startDate, Date endDate);
	public Optional<Consultation> findByReferenceFT(String referenceFt);
	public List<Consultation> findByDateRegleBetween(java.util.Date firstDate,java.util.Date lastDate);
	//List<Consultation> findByLoginAndDateRegleBetween(String login, Date startDate, Date endDate);
}
