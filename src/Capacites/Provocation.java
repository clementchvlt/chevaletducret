package Capacites;

import Application.HearthstoneException;

/**
*Si le joueur a une carte sur le plateau 		
*qui possede cette capacite alors
*l�adversaire ne peut attaquer 
*que ces cartes tant qu�elle sont
*en jeu
*@authorCorentin/Clement
*/

public class Provocation extends Capacite{

	public Provocation(String nom, String descritpion) {
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

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
