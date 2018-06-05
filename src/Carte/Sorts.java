package Carte;

import Joueur.IJoueur;
import Application.HearthstoneException;
import Capacites.ICapacite;

/**
*Classe serviteur, un sort est une carte présente dans le deck, le jeu et la main
* @see Carte
*@author Corentin/Clement
*/

public class Sorts extends Carte {

	
	public Sorts(String nom, int cout, ICapacite capacite) {
		super(nom, cout, capacite);
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		
		return "Sort[Nom=" + getNom() + ", Prix=" + getCout() + ", " + getCapacite() + "]";
		
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
		this.getCapacite().executerAction(cible);
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


	@Override
	public int getVie() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setVie(int vie) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getAttaque() {
		// TODO Auto-generated method stub
		return 0;
	}


}
