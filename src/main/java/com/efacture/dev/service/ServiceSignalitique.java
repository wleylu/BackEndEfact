package com.efacture.dev.service;

 

import java.util.List;
import java.util.Optional;

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.SignalitiqueTest;
import com.efacture.dev.model.Utilisateur;

 

public interface ServiceSignalitique {
    //public CompteMarchand ajouterCm(CompteMarchand c); 
	public SignalitiqueTest ajouterCm(SignalitiqueTest c);
	public List<SignalitiqueTest> listMarchands();
    //public List<CompteMarchand> rechercheByNom(String nom);
    //public List<Comptes> cpt();
    //public List<CompteMarchand> getListeMarchands();
	 public SignalitiqueTest getMarchand(String client);
    
    //public List<CompteMarchand> list();
}