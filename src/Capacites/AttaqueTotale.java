package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*Classe pour les attaques sans cible, 	
*mais envers tous les serviteurs du jeu
*see Capacite
*@authorCorentin/Clement
*/
public class AttaqueTotale extends Capacite{
	private int attaque;

	public AttaqueTotale(String nom, String descritpion, int attaque) {
		super(nom, descritpion);
		this.attaque=attaque;
	}

	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	/**
	*enleve le nombre de points d’attaque 		
	*a chaque serviteurs du jeu, si la carte 	
	*atteint les 0 points ou moins alors elle 	
	*disparait du jeu
	*@param cible la cible a atteindre
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for(ICarte c: Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu()) {
			Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(c.getNom()).setVie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(c.getNom()).getVie()-attaque);
			if(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(c.getNom()).getVie()<=0) {
				Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).perdreCarte(c);
				
			}
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
