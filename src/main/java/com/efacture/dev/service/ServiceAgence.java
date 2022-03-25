package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.Agence;


public interface ServiceAgence {
	public Agence addAgence(Agence agence);
	public List<Agence> agence();
	public Agence updateAgence(Agence agence);

}
