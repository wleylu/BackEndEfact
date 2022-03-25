package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.efacture.dev.model.EmmissionCie;
import com.efacture.dev.repository.EmCieRepository;
import com.efacture.dev.repository.EmSodeciRepository;
import com.efacture.dev.service.EmCieService;
import com.efacture.dev.service.EmSodeciService;

@Service
public class EmCieServiceImpl implements EmCieService{

	
		@Autowired
		private EmCieRepository emCieRepository;
		@Override
		public List<EmmissionCie> getByIdabon(String idabon) {
			try {
				List<EmmissionCie> idabonne = emCieRepository.findByIdabonner(idabon);
				EmmissionCie EmissionCie= new EmmissionCie();
				if (idabonne != null) {
					System.out.println("ok");
					System.out.println(idabonne);
					return idabonne;
				}else {
					System.out.println("oooooooook");
					return new ArrayList<>();
				}
			} catch (Exception e) {
				System.out.println("oooooooooo1oooooooook");
				return new ArrayList<>();
			}
		}
		@Override
		public List<EmmissionCie> getByStatut(String statut) {
			try {
				List<EmmissionCie> statuts = emCieRepository.findByStatut(statut);
				if (statuts != null) {
					System.out.println("ok");
					System.out.println(statuts);
					return statuts;
				}else {
					System.out.println("oooooooook");
					return new ArrayList<>();
				}
			} catch (Exception e) {
				System.out.println("oooooooooo1oooooooook");
				return new ArrayList<>();
			}
		}
		@Override
		public EmmissionCie updateStatut(EmmissionCie EmissionCie) {
			try {
				EmmissionCie EmissionCie2 = new EmmissionCie();
				EmmissionCie currentEmissionCie = emCieRepository.findByIdabonAndPerfact(EmissionCie.getIdabon(), EmissionCie.getPerfact());
				if (currentEmissionCie != null) {
					System.out.println("ok");
					currentEmissionCie.setStatut(EmissionCie.getStatut());
					return emCieRepository.save(currentEmissionCie);
				} else {
					System.out.println("oooooooook");
					return new EmmissionCie();
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new EmmissionCie();
			}
		}
		@Override
		public EmmissionCie getByIdAbonAndPeriode(String idabon, String perfact) {
			try {
				EmmissionCie IdAbonAndPeriode = emCieRepository.findByIdabonAndPerfact(idabon, perfact);
				if (IdAbonAndPeriode != null) {
					System.out.println("ok");
					System.out.println(IdAbonAndPeriode);
					return IdAbonAndPeriode;
				}else {
					System.out.println("oooooooook");
					return new EmmissionCie();
				}
			} catch (Exception e) {
				System.out.println("oooooooooo1oooooooook");
				return new EmmissionCie();
			}
		}

	}
