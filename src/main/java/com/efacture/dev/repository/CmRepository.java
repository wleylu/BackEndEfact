package com.efacture.dev.repository;

 

import java.util.Date;
import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Consultation;
 

public interface CmRepository extends JpaRepository<CompteMarchand, String> {
    public CompteMarchand findByClient(String client);
    public CompteMarchand findByEmail(String email);
    public List<CompteMarchand> findByNomContaining(String nom);
    public List<CompteMarchand> findByLoginContaining(String login);
    public List<CompteMarchand> findByLogin(String login);
    public List<CompteMarchand> findByNomContainingIgnoreCaseAndLoginContainingIgnoreCase(String nom,String login);
    List<CompteMarchand> findAllByDateCreationBetween(Date dateDebut,Date dateFin);
    //public CompteMarchand findByCode(Long code);
    /*
     * @Query("Select c from CompteMarchand c where c.nom like :x") public
     * List<CompteMarchand> rechercheByCm(@Param("x") String cm);
     */
    @Query(value = "SELECT email FROM compte_marchand WHERE email=?1", nativeQuery = true)
	public String getByMarchandByMail(String email);
	public CompteMarchand findByTel(String tel);
}