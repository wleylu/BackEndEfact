package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_transaction;
	@Value("PAIE|M|M|")
	private String prefixe;
	private String facturier;
	@Temporal(TemporalType.DATE)
	private Date datOper = new Date(System.currentTimeMillis());;
	private String codOper;
	private String identifiantFacture;
	private String compteDebit;
	private String compteCredit;
	private long mntOper; // montant de la facture a débiter + frais
	private long mntFacture; // montant da la facture sans les frais
	private long mntFrais; // montant des frais
	private long mntMarchand; // montant de la part de la banque
	private long mntFraisMarchand; // frais monta&nt part marchand
	private long mntTimbre; // fris de timbre
	private String libelleOper; // libelle de l'opération
	private String compteCom; // compte de commision
	private String refOld;
	private String statutTraitement;
	private long codeTraitement;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(long id_transaction, String prefixe, String facturier, Date datOper, String codOper,
			String identifiantFacture, String compteDebit, String compteCredit, long mntOper, long mntFacture,
			long mntFrais, long mntMarchand, long mntFraisMarchand, long mntTimbre, String libelleOper,
			String compteCom, String refOld, String statutTraitement, long codeTraitement) {
		super();
		this.id_transaction = id_transaction;
		this.prefixe = prefixe;
		this.facturier = facturier;
		this.datOper = datOper;
		this.codOper = codOper;
		this.identifiantFacture = identifiantFacture;
		this.compteDebit = compteDebit;
		this.compteCredit = compteCredit;
		this.mntOper = mntOper;
		this.mntFacture = mntFacture;
		this.mntFrais = mntFrais;
		this.mntMarchand = mntMarchand;
		this.mntFraisMarchand = mntFraisMarchand;
		this.mntTimbre = mntTimbre;
		this.libelleOper = libelleOper;
		this.compteCom = compteCom;
		this.refOld = refOld;
		this.statutTraitement = statutTraitement;
		this.codeTraitement = codeTraitement;
	}

	public long getId() {
		return id_transaction;
	}

	public void setId(long id) {
		this.id_transaction = id_transaction;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

	public String getFacturier() {
		return facturier;
	}

	public void setFacturier(String facturier) {
		this.facturier = facturier;
	}

	public Date getDatOper() {
		return datOper;
	}

	public void setDatOper(Date datOper) {
		this.datOper = datOper;
	}

	public String getCodOper() {
		return codOper;
	}

	public void setCodOper(String codOper) {
		this.codOper = codOper;
	}

	public String getIdentifiantFacture() {
		return identifiantFacture;
	}

	public void setIdentifiantFacture(String identifiantFacture) {
		this.identifiantFacture = identifiantFacture;
	}

	public String getCompteDebit() {
		return compteDebit;
	}

	public void setCompteDebit(String compteDebit) {
		this.compteDebit = compteDebit;
	}

	public String getCompteCredit() {
		return compteCredit;
	}

	public void setCompteCredit(String compteCredit) {
		this.compteCredit = compteCredit;
	}

	public long getMntOper() {
		return mntOper;
	}

	public void setMntOper(long mntOper) {
		this.mntOper = mntOper;
	}

	public long getMntFacture() {
		return mntFacture;
	}

	public void setMntFacture(long mntFacture) {
		this.mntFacture = mntFacture;
	}

	public long getMntFrais() {
		return mntFrais;
	}

	public void setMntFrais(long mntFrais) {
		this.mntFrais = mntFrais;
	}

	public long getMntMarchand() {
		return mntMarchand;
	}

	public void setMntMarchand(long mntMarchand) {
		this.mntMarchand = mntMarchand;
	}

	public long getMntFraisMarchand() {
		return mntFraisMarchand;
	}

	public void setMntFraisMarchand(long mntFraisMarchand) {
		this.mntFraisMarchand = mntFraisMarchand;
	}

	public long getMntTimbre() {
		return mntTimbre;
	}

	public void setMntTimbre(long mntTimbre) {
		this.mntTimbre = mntTimbre;
	}

	public String getLibelleOper() {
		return libelleOper;
	}

	public void setLibelleOper(String libelleOper) {
		this.libelleOper = libelleOper;
	}

	public String getCompteCom() {
		return compteCom;
	}

	public void setCompteCom(String compteCom) {
		this.compteCom = compteCom;
	}

	public String getRefOld() {
		return refOld;
	}

	public void setRefOld(String refOld) {
		this.refOld = refOld;
	}

	public String getStatutTraitement() {
		return statutTraitement;
	}

	public void setStatutTraitement(String statutTraitement) {
		this.statutTraitement = statutTraitement;
	}

	public long getCodeTraitement() {
		return codeTraitement;
	}

	public void setCodeTraitement(long codeTraitement) {
		this.codeTraitement = codeTraitement;
	}

	@Override
	public String toString() {
		return "Transaction [id_transaction=" + id_transaction + ", prefixe=" + prefixe + ", facturier=" + facturier + ", datOper=" + datOper
				+ ", codOper=" + codOper + ", identifiantFacture=" + identifiantFacture + ", compteDebit=" + compteDebit
				+ ", compteCredit=" + compteCredit + ", mntOper=" + mntOper + ", mntFacture=" + mntFacture
				+ ", mntFrais=" + mntFrais + ", mntMarchand=" + mntMarchand + ", mntFraisMarchand=" + mntFraisMarchand
				+ ", mntTimbre=" + mntTimbre + ", libelleOper=" + libelleOper + ", compteCom=" + compteCom + ", refOld="
				+ refOld + ", statutTraitement=" + statutTraitement + ", codeTraitement=" + codeTraitement + "]";
	}

	
}