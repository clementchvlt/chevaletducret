package Plateau;

import Application.HearthstoneException;
import Joueur.IJoueur;
import Joueur.Joueur;

public class Plateau implements IPlateau {
	
	private Joueur joueurCourant;
	private Joueur adversaire;
	
	public Plateau(Joueur joueurCourant, Joueur adversaire) throws HearthstoneException {
		setJoueurCourant(joueurCourant);
		setAdversaire(adversaire);
		
	}
	
	private void setAdversaire(Joueur adversaire) {
		this.adversaire=adversaire;
	}

	@Override
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IJoueur getJoueurCourant() {
		return this.joueurCourant;
	}

	@Override
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		this.joueur=joueur;
		
	}

	@Override
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estDemarree() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
}
