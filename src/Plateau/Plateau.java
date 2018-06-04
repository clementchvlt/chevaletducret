package Plateau;

import java.util.ArrayList;
import java.util.Collections;

import Application.HearthstoneException;
import Carte.ICarte;
import Joueur.IJoueur;
import Joueur.Joueur;

public class Plateau implements IPlateau {
	
	private IJoueur joueurCourant;
	private boolean demarre=false;
	private IJoueur adversaire;
	private ArrayList<IJoueur> listeJoueurs= new ArrayList<IJoueur>();
	private static IPlateau plateau;
	
	public Plateau() {
		this.joueurCourant=null;
		
	}
	
	public static Plateau plateau() throws HearthstoneException {
		if(plateau==null)
			plateau=new Plateau();
		return (Plateau) plateau;
	}
	
	private void setAdversaire(IJoueur adversaire) {
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
		if(listeJoueurs.get(0)==joueur) 
			return listeJoueurs.get(1);
		else
			return listeJoueurs.get(0);
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		if(listeJoueurs.size() == 2) {
			Collections.shuffle(listeJoueurs);
			joueurCourant=listeJoueurs.get(0);
			demarre=true;
		}
		else throw new HearthstoneException("Il n'y a pas 2 Joueurs");
	}

	@Override
	public boolean estDemarree() {
		return demarre;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if(joueur==getJoueurCourant()) {
			IJoueur J = getAdversaire(joueur);
			adversaire = joueur;
			joueur = J;
		}
		else throw new HearthstoneException("Ca n'est pas Ã  toi de jouer");
	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		System.out.println("le joueur" + joueur.getPseudo() + "gagne la partie");
	}

	public String toString() {
		String partie = null;
		if (this.estDemarree()) {
			partie = "\nPartie démarrée\n"+ getJoueurCourant().getPseudo() + " - " +getJoueurCourant().getHeros()+"\n\nVotre main :\n";
			partie += "######################################################\n";
				try {
					for(ICarte carte: Plateau.plateau().getJoueurCourant().getMain())
					{
						partie += carte.toString();
					}
				} catch (HearthstoneException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		
			partie += "######################################################\n";

			partie += "\nCartes en jeu :";
			partie += "\n=====================================================\n";
			for(ICarte carte: getJoueurCourant().getJeu())
			{
				partie += carte.toString();
			}
			partie += "\n\n======================\n\n";
			try {
				for(ICarte carte: Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu())
				{
					partie += carte.toString();
				}
			} catch (HearthstoneException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			partie += "\n=====================================================\n\n";
			try {
				partie += getAdversaire(getJoueurCourant()).getPseudo() + " - " +getAdversaire(getJoueurCourant()).getHeros() + "\n";
			} catch (HearthstoneException e) {
				e.printStackTrace();
			}
		} else
			partie = "Cette partie n'est pas demarrée";
		return partie;
	}

}
