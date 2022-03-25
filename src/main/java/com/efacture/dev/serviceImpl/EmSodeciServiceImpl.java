package com.efacture.dev.serviceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.EmmissionSodeci;
import com.efacture.dev.repository.EmSodeciRepository;
import com.efacture.dev.service.EmSodeciService;


@Service
public class EmSodeciServiceImpl implements EmSodeciService {
	@Autowired
	private EmSodeciRepository emSodeciRepository;
	@Override
	public List<EmmissionSodeci> getByIdabon(String idabon) {
		try {
			List<EmmissionSodeci> idabonne = emSodeciRepository.findByIdabonner(idabon);
			EmmissionSodeci emmissionSodeci= new EmmissionSodeci();
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
	public List<EmmissionSodeci> getByStatut(String statut) {
		try {
			List<EmmissionSodeci> statuts = emSodeciRepository.findByStatut(statut);
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
	public EmmissionSodeci updateStatut(EmmissionSodeci emmissionSodeci) {
		try {
			EmmissionSodeci emmissionSodeci2 = new EmmissionSodeci();
			EmmissionSodeci currentEmmissionSodeci = emSodeciRepository.findByIdabonAndPerfact(emmissionSodeci.getIdabon(), emmissionSodeci.getPerfact());
			if (currentEmmissionSodeci != null) {
				System.out.println("ok");
				currentEmmissionSodeci.setStatut(emmissionSodeci.getStatut());
				return emSodeciRepository.save(currentEmmissionSodeci);
			} else {
				System.out.println("oooooooook");
				return new EmmissionSodeci();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new EmmissionSodeci();
		}
	}
	@Override
	public EmmissionSodeci getByIdAbonAndPeriode(String idabon, String perfact) {
		try {
			EmmissionSodeci IdAbonAndPeriode = emSodeciRepository.findByIdabonAndPerfact(idabon, perfact);
			if (IdAbonAndPeriode != null) {
				System.out.println("ok");
				System.out.println(IdAbonAndPeriode);
				return IdAbonAndPeriode;
			}else {
				System.out.println("oooooooook");
				return new EmmissionSodeci();
			}
		} catch (Exception e) {
			System.out.println("oooooooooo1oooooooook");
			return new EmmissionSodeci();
		}
	}

}
