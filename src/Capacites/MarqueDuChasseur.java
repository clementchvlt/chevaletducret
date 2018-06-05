package Capacites;

import Application.HearthstoneException;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*Reduit a 1 les pv de la cible
*see Capacite
*@authorCorentin/Clement
*/

public class MarqueDuChasseur extends Capacite{

	public MarqueDuChasseur(String nom, String descritpion) {
		super(nom, descritpion);
		// TODO Auto-generated constructor stub
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
	*abaisse les pv de la cible a 1
	*@param cible la cible a atteindre
	*@throws HearthstoneException si pas 	
	*de cible ou si la cible n’est pas en jeu 		
	*ou si la cible n’est pas un serviteur
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		if(cible == null)
			throw new HearthstoneException("La cible est nulle like u");
		if(cible instanceof Serviteur) {
			if(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu().contains((Serviteur) cible))
				((Serviteur) Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(((Serviteur) cible).getNom())).setVie(1);
			else throw new HearthstoneException("La cible est comme Benzema pendant la coupe du Monde...");
		}
		else
			throw new HearthstoneException("La cible n'est pas un serviteur");
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
