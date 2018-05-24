package Plateau;

import java.util.ArrayList;

import Application.HearthstoneException;
import Joueur.IJoueur;
import Joueur.Joueur;

public class Plateau implements IPlateau {
	
	private IJoueur joueurCourant;
	private IJoueur adversaire;
	private ArrayList<IJoueur> listeJoueurs;
	
	public Plateau(Joueur joueurCourant, Joueur adversaire, ArrayList<IJoueur> listeJoueurs) throws HearthstoneException {
		setJoueurCourant(joueurCourant);
		setAdversaire(adversaire);
		this.listeJoueurs = listeJoueurs;
		
	}
	
	private void setAdversaire(Joueur adversaire) {
		this.adversaire=adversaire;
	}
	
	@Override
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		
	}

	@Override
	public IJoueur getJoueurCourant() {
		return this.joueurCourant;
	}

	@Override
	public void setJoueurCourant(IJoueur joueurCourant) throws HearthstoneException {
		this.joueurCourant=joueurCourant;
		
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
