package Capacites;

import Application.HearthstoneException;
import Plateau.Plateau;

/**
*fait piocher un certain nombre i de 		
*cartes
*@authorCorentin/Clement
*/
public class Pioche extends Capacite{

	private int nbPioche;
	
	public Pioche(String nom, String descritpion, int nbPioche) {
		super(nom, descritpion);
		this.nbPioche=nbPioche;
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
	*pioche i cartes dans le deck du joueur
	*et les met dans sa main
	*@param cible la carte a atteindre
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		for(int i=1; i<=nbPioche; i++) {
			try {
				Plateau.plateau().getJoueurCourant().piocher();
			} catch (HearthstoneException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
