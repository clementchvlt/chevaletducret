package Carte;

import Joueur.IJoueur;
import Capacites.ICapacite;

public class Sorts extends Carte {

	
	public Sorts(IJoueur proprietaire, String nom, int cout, ICapacite capacite) {
		super(nom, cout, proprietaire, capacite);
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		
		return "Sort[Proprietaire=" + getProprietaire().getPseudo() + ", Nom=" + getNom() + ", Prix=" + getCout() + ", " + getCapacite() + "]";
		
	}


}
