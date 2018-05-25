package Plateau;

import java.util.ArrayList;
import java.util.Collections;

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
		if(listeJoueurs.size()<2) {
			listeJoueurs.add(joueur);
		}else throw new HearthstoneException("Maximum de 2 joueurs");
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
		if(listeJoueurs.get(1)==joueur) 
			return listeJoueurs.get(2);
		else
			return listeJoueurs.get(1);
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		if(listeJoueurs.size() == 2) {
			Collections.shuffle(listeJoueurs);
			joueurCourant=listeJoueurs.get(1);
		}
		else throw new HearthstoneException("Il n'y a pas 2 Joueurs");
	}

	@Override
	public boolean estDemarree() {
		if(joueurCourant.getMana()>0) 
			return true;
		else
			return false;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if(joueur==getJoueurCourant()) {
			IJoueur J = getAdversaire(joueur);
			adversaire = joueur;
			joueur = J;
		}
		else throw new HearthstoneException("Ca n'est pas à toi de jouer");
	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
