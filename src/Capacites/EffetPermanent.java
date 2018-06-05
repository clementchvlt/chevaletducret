package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*Classe pour les effets qui s’appliquent
*tout le temps sur la cible 
*see Capacite
*@authorCorentin/Clement
*/

public class EffetPermanent extends Capacite{

	private int bonusAttaque;
	private int bonusVie;
	
	public EffetPermanent(String nom, String descritpion, int bonusAttaque, int bonusVie) {
		super(nom, descritpion);
		this.bonusAttaque=bonusAttaque;
		this.bonusVie=bonusVie;
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
	*ajoute les bonus d’attaque et de vie a 		
	*la cible
	*@param cible la ciblee a atteindre
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for(ICarte c : Plateau.plateau().getJoueurCourant().getJeu() ) {
			
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setAttaque(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getAttaque()+this.bonusAttaque);
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setVie(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getVie()+this.bonusVie);
		
		}
		
	}

	/**
	*retire les bonus de vies et d’attaque a 		
	*la cible 
	*@param cible la cible a atteindre
	*@throws HearthstoneException si pas 	
	*de cible ou si m’adversaire ne possède 	
	*pas la cible
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		for(ICarte c : Plateau.plateau().getJoueurCourant().getJeu() ) {
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setAttaque(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getAttaque()-this.bonusAttaque);
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setVie(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getVie()-this.bonusVie);
			
		}
	}
}
