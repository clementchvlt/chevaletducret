package Carte;

import Capacites.ICapacite;
import Joueur.IJoueur;

public class Serviteur extends Carte{
	
	private int vie, attaque;
	private boolean peutAttaquer;
	private ICapacite capacite;
	private int vieRestante;
	
	public Serviteur( IJoueur proprietaire ,String nom, int cout, int vie, int attaque, ICapacite capacite, boolean peutAttaquer, int vieRestante) {
		super( nom, cout,proprietaire, capacite);
		setVie(vie); //vie initiale du Serviteur
		setAttaque(attaque);
		setPeutAttaquer(peutAttaquer);
		setCapacite(capacite);
		setVieRestante(vie); //vie actuelle du serviteur
	}
	
	private void setVieRestante(int vieRestante) {
		this.vieRestante=vieRestante;
		
	}

	private void setCapacite(ICapacite capacite) {
		this.capacite=capacite;
	}
	
	public ICapacite getCapacite() {
		return capacite;
	}

	public int getVie() {
		return vie;
	}
	
	public int getVieRestante() {
		return vieRestante;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	public boolean getPeutAttaquer() {
		if (this.getCapacite().getNom()=="Charge") {
			return true;
		}else return false;
	}

	public void setPeutAttaquer(boolean peutAttaquer) {
		this.peutAttaquer = peutAttaquer;
	}
	
	public String toString(){
		return "Serviteur[Proprietaire= " + this.getProprietaire().getPseudo() + ", Nom=" + this.getNom() + ", Cout=" + getCout() + ", Vie=" + getVie() + ", Attaque=" + getAttaque() + ", " + getCapacite() + "]";
	}

	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Serviteur)) throw new IllegalArgumentException();
		
		Serviteur s=(Serviteur)o;
		if((s.getNom().equals(this.getNom())) && (s.getCout()== this.getCout()) && (s.getVie() == this.getVie()) && (s.getAttaque() == this.getAttaque())  && (s.getProprietaire()== this.getProprietaire()) )return true;
		return false;
	}
	
}