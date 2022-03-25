package com.efacture.dev.conttroller;

 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;

import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.serviceImpl.CmImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class CmController {
    @Autowired
    private CmImpl cmImpl;
    

    @GetMapping("/cm/admin/marchands")
    public ResponseEntity<List<CompteMarchand>> recupererCptMarchand1(){
        try {
        	return ResponseEntity.ok(cmImpl.listMarchands());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.ok(new ArrayList<>());
		}
        
    }
    @PostMapping("/cm/admin/marchandAdd")
    public ResponseEntity<CompteMarchand> ajouterCptMarchand(@RequestBody CompteMarchand c){ 
        return ResponseEntity.ok(cmImpl.ajouterCm(c));  
    }
    @GetMapping("/cm/admin/marchand/{racine}")
    public ResponseEntity<CompteMarchand> recherchebyClient(@PathVariable String racine){
        return ResponseEntity.ok(cmImpl.getMarchand(racine));
    }
    @GetMapping("/cm/admin/getByMarchandByMail/{email}")
    public ResponseEntity<String> getByMarchandByMail(@PathVariable String email){
        return ResponseEntity.ok(cmImpl.getByMarchandByMail(email));
    }
    @GetMapping("/cm/admin/recherchebyEmail/{email}")
    public ResponseEntity<CompteMarchand> recherchebyEmail(@PathVariable String email){
        return ResponseEntity.ok(cmImpl.getByEmail(email));
    }
    @GetMapping("/cm/admin/recherchebyTel/{tel}")
    public ResponseEntity<CompteMarchand> recherchebyTel(@PathVariable String tel){
        return ResponseEntity.ok(cmImpl.getByTel(tel));
    }

    @PutMapping("/cm/admin/marchandModif")
	public ResponseEntity<CompteMarchand> modifierCm(@RequestBody CompteMarchand cptMarchand){
		return ResponseEntity.ok(cmImpl.modifierCm(cptMarchand));
	}

    @GetMapping("/cm/admin/consultation")
    public ResponseEntity<List<CompteMarchand>> recherchenomlogin(@RequestParam(value = "nom") 
    String nom,@RequestParam(value = "login") String login){
        return ResponseEntity.ok(cmImpl.rechercheByNomAndLogin(nom,login));
    }
    
}