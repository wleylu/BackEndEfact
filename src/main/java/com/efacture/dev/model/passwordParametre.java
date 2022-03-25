package com.efacture.dev.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class passwordParametre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nbJours;
	
	
	public passwordParametre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	public passwordParametre(int id, int nbJours) {
		super();
		this.id = id;
		this.nbJours = nbJours;
	}
	@Override
	public String toString() {
		return "passwordParametre [id=" + id + ", nbJours=" + nbJours + "]";
	}

}
