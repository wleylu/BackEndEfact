package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ReglementSodeci;
import com.efacture.dev.repository.RgSodeciRepository;
import com.efacture.dev.service.RgSodeciService;
@Service
public class RgSodeciServiceImpl implements RgSodeciService {
	@Autowired
	private RgSodeciRepository rgSodeciRepository;
	@Override
	public ReglementSodeci addReglement(ReglementSodeci reglementSodeci) {
		try {
			System.out.println("ok");
			return rgSodeciRepository.save(reglementSodeci);
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooook");
			return new ReglementSodeci();
		}
	}

	@Override
	public ReglementSodeci updateReglement(ReglementSodeci reglementSodeci) {
		try {
			ReglementSodeci currentRgSodeci = rgSodeciRepository.findById(reglementSodeci.getIdRgSodeci()).get();
			if (currentRgSodeci != null) {
				System.out.println("ok");
				return rgSodeciRepository.save(currentRgSodeci);
			}else {
				System.out.println("oooooooook");
				return new ReglementSodeci();
			}
		} catch (Exception e) {
			return new ReglementSodeci();
		}
	}

	@Override
	public List<ReglementSodeci> listeReglement() {
		try {
			List<ReglementSodeci> rgSodeci = rgSodeciRepository.findAll();
			if (rgSodeci !=null) {
				System.out.println("ok");
				return rgSodeci;
			}else {
				System.out.println("oooooooook");
				return new ArrayList<>();
			}
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooooooooooooooook");
			return new ArrayList<>();
		}
	}

	@Override
	public List<ReglementSodeci> getReglementByStatut(String statut) {
		try {
			List<ReglementSodeci> rgSodeci = rgSodeciRepository.findByStatut(statut);
			if (rgSodeci !=null) {
				System.out.println("ok");
				return rgSodeci;
			}else {
				System.out.println("oooooooook");
				return new ArrayList<>();
			}
		} catch (Exception e) {
			System.out.println("oooooooooooooooooooooooooooooooook");
			return new ArrayList<>();
		}
	}

}
