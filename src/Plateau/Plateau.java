package Plateau;

import java.util.ArrayList;
import java.util.Collections;

import Application.HearthstoneException;
import Carte.ICarte;
import Joueur.IJoueur;
import Joueur.Joueur;

/**
	*Class Plateau qui represente le plateau de jeu, contenant les jeux des deux joueurs
	*@author Corentin/Clement
	*/

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
	
	public void setAdversaire(IJoueur adversaire) {
		this.adversaire=adversaire;
	}
	
	/**
	*Permet d’ajouter un joueur a la partie (max 2 joueurs)
	*@joueur le joueur a ajouter
	*@throws HearthstoneException si il y a deja 2 joueurs dans la partie
	*@authorCorentin/Clement
	*/
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		if(listeJoueurs.size()<2) {
			listeJoueurs.add(joueur);
		}else throw new HearthstoneException("Maximum de 2 joueurs");
	}

	/**
	*permet de savoir qui a la main
	*@return joueurCourant qui est le joueur qui a la main
	*@authorCorentin/Clement
	*/
	public IJoueur getJoueurCourant() {
		return this.joueurCourant;
	}

	public void setJoueurCourant(IJoueur joueurCourant) throws HearthstoneException {
		this.joueurCourant=joueurCourant;
		
	}

	/**
	*permet de savoir qui est l’adversaire de joueurCourant
	*@param joueur joueurCourant
	*@return adversaire
	*@authorCorentin/Clement
	*/
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		if(listeJoueurs.get(0)==joueur) 
			return listeJoueurs.get(1);
		else
			return listeJoueurs.get(0);
	}
	
	/**
	*melange aleatoirement la liste de joueurs et choisi celui qui commence
	*@throws HearthstoneException si il n’y a pas assez de joueurs (il en faut exactement 2pour demarrer la partie)
	*@authorCorentin/Clement
	*/
	public void demarrerPartie() throws HearthstoneException {
		if(listeJoueurs.size() == 2) {
			Collections.shuffle(listeJoueurs);
			joueurCourant=listeJoueurs.get(0);
			demarre=true;
		}
		else throw new HearthstoneException("Il n'y a pas 2 Joueurs");
	}

	/**
	*permet de savoir si la partie est commencée
	*@return true si partie est demarree et false sinon
	*@author Corentin/Clement
	*/
	public boolean estDemarree() {
		return demarre;
	}

	/**
	*permet de passer le tour a l’adversaire
	*@param joueur joueurCourant
	*@throws HearthstoneException si le joueur qui tente de finir la partie n’a pas la main
	*@authorCorentin/Clement
	*/
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if(joueur==getJoueurCourant()) {
			IJoueur J = getAdversaire(joueur);
			adversaire = joueur;
			joueur = J;
		}
		else throw new HearthstoneException("Ca n'est pas à toi de jouer");
	}

	/**
	*affiche le nom du gagnant de la partie
	*@param joueur joueur qui a gagne la partie
	*@return nom du joueur qui gagne
	*@authorCorentin/Clement
	*/
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		System.out.println("le joueur" + joueur.getPseudo() + "gagne la partie");
	}

	public String toString() {
		String partie = null;
		if (this.estDemarree()) {
			partie = "\n" + getJoueurCourant().getPseudo() + " - " +getJoueurCourant().getHeros()+"\n\nVotre main :\n";
			partie += "######################################################\n";
				try {
					for(ICarte carte: Plateau.plateau().getJoueurCourant().getMain())
					{
						partie += carte.toString()+"\n";
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
			partie = "Cette partie n'est pas demarr�e";
		return partie;
	}

}
