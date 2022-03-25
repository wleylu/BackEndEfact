package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ReglementCie;
import com.efacture.dev.repository.RgCieRepository;
import com.efacture.dev.service.RgCieService;
@Service
public class RgCieServiceImpl implements RgCieService {
	@Autowired
	private RgCieRepository rgCieRepository;

	@Override
	public ReglementCie addReglement(ReglementCie reglementCie) {
		try {
			System.out.println("ok");
			return rgCieRepository.save(reglementCie);
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooook");
			return new ReglementCie();
		}
	}

	@Override
	public ReglementCie updateReglement(ReglementCie reglementCie) {
		try {
			ReglementCie currentRgCie = rgCieRepository.findById(reglementCie.getIdRgCie()).get();
			if (currentRgCie != null) {
				System.out.println("ok");
				return rgCieRepository.save(currentRgCie);
			} else {
				System.out.println("oooooooook");
				return new ReglementCie();
			}
		} catch (Exception e) {
			return new ReglementCie();
		}
	}

	@Override
	public List<ReglementCie> listeReglement() {
		try {
			List<ReglementCie> rgCie = rgCieRepository.findAll();
			if (rgCie != null) {
				System.out.println("ok");
				return rgCie;
			} else {
				System.out.println("oooooooook");
				return new ArrayList<>();
			}
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooooooooooooooook");
			return new ArrayList<>();
		}
	}

	@Override
	public List<ReglementCie> getReglementByStatut(String statut) {
		try {
			List<ReglementCie> rgCie = rgCieRepository.findByStatut(statut);
			if (rgCie != null) {
				System.out.println("ok");
				return rgCie;
			} else {
				System.out.println("oooooooook");
				return new ArrayList<>();
			}
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooooooooooooooook");
			return new ArrayList<>();
		}
	}

}



