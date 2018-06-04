package Carte;

import Application.HearthstoneException;
import Capacites.Charge;
import Capacites.ICapacite;
import Joueur.IJoueur;

public class Serviteur extends Carte{
	
	private int vie, attaque;
	private boolean peutAttaquer;
	private ICapacite capacite;
	
	public Serviteur(String nom, int cout, int vie, int attaque, ICapacite capacite, boolean peutAttaquer) {
		super( nom, cout,capacite);
		setVie(vie); 
		setAttaque(attaque);
		setPeutAttaquer(peutAttaquer);
		setCapacite(capacite);
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
		if (this.getCapacite()instanceof Charge) {
			return true;
		}else return false;
	}

	public void setPeutAttaquer(boolean peutAttaquer) {
		this.peutAttaquer = peutAttaquer;
	}
	
	public String toString(){
		return "Serviteur[Nom=" + this.getNom() + ", Cout=" + getCout() + ", Vie=" + getVie() + ", Attaque=" + getAttaque() + ", " + getCapacite() + "]";
	}

	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Serviteur)) throw new IllegalArgumentException();
		
		Serviteur s=(Serviteur)o;
		if((s.getNom().equals(this.getNom())) && (s.getCout()== this.getCout()) && (s.getVie() == this.getVie()) && (s.getAttaque() == this.getAttaque()) )return true;
		return false;
	}

	@Override
	public void executerEffetDebutTour(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
	}
	
}