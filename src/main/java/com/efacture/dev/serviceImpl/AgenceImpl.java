package com.efacture.dev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Agence;
import com.efacture.dev.repository.AgenceRespository;
import com.efacture.dev.service.ServiceAgence;

@Service
public class AgenceImpl implements ServiceAgence {

	@Autowired
	private AgenceRespository agenceRep;

	@Override
	public Agence addAgence(Agence agence) {
		// TODO Auto-generated method stub
		return agenceRep.save(agence);
	}

	@Override
	public List<Agence> agence() {
		// TODO Auto-generated method stub
		return agenceRep.findAll();
	}

	@Override
	public Agence updateAgence(Agence agence) {
		// TODO Auto-generated method stub

		Agence agence2 = agenceRep.findById(agence.getId()).get();

		if (agence2 != null) {
			return agenceRep.save(agence2);
		}

		return new Agence();

	}

}
