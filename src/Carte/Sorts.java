package Carte;

import Joueur.IJoueur;
import Capacites.ICapacite;

public class Sorts extends Carte {

	private ICapacite capacite;
	
	public Sorts(IJoueur proprietaire, String nom, int cout, ICapacite capacite) {
		super(nom, cout, proprietaire);
		setCapacite(capacite);
		// TODO Auto-generated constructor stub
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public String toString() {
		
		return "Sort[Proprietaire=" + getProprietaire().getPseudo() + ", Nom=" + getNom() + ", Prix=" + getCout() + ", " + getCapacite() + "]";
		
	}


}
