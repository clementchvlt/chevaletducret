package Capacites;

import Application.HearthstoneException;

/**
*Si le serviteur possède charge alors il 		
*peut attaquer des son premier tour
*see Capacite
*@authorCorentin/Clement
*/
public class Charge extends Capacite{

	public Charge(String nom, String descritpion) {
		super(nom, descritpion);
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
		
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
