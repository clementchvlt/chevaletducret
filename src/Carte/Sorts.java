package Carte;

import Joueur.IJoueur;
import Application.HearthstoneException;
import Capacites.ICapacite;

public class Sorts extends Carte {

	
	public Sorts(IJoueur proprietaire, String nom, int cout, ICapacite capacite) {
		super(nom, cout, proprietaire, capacite);
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		
		return "Sort[Proprietaire=" + getProprietaire().getPseudo() + ", Nom=" + getNom() + ", Prix=" + getCout() + ", " + getCapacite() + "]";
		
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


	@Override
	public boolean getPeutAttaquer() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setPeutAttaquer(boolean peutAttaquer) {
		// TODO Auto-generated method stub
		
	}


}
