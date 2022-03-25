package com.efacture.dev.service;

 

import java.util.List;
import java.util.Optional;

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.Utilisateur;

 

public interface ServiceCm {
    //public CompteMarchand ajouterCm(CompteMarchand c); 
	public CompteMarchand ajouterCm(CompteMarchand c);
    public List<CompteMarchand> listMarchands();
    //public List<CompteMarchand> rechercheByNom(String nom);
    //public List<Comptes> cpt();
    //public List<CompteMarchand> getListeMarchands();
    public CompteMarchand getMarchand(String client);
    public CompteMarchand getByEmail(String email);
    public String getByMarchandByMail(String email);
    public List<CompteMarchand> rechercheByLogin(String login);
    public List<CompteMarchand> rechercheByNomAndLogin(String nom,String login);
    public CompteMarchand modifierCm(CompteMarchand cptMarchand);
    //public List<CompteMarchand> list();
}