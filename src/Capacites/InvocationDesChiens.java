package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

public class InvocationDesChiens extends InvocationDeServiteurs{

	private static ICarte serviteur = new Serviteur("Chien", 0, 1, 1, new Charge("charge", "permet d'attaquer des le premier tour"), true);
	
	public InvocationDesChiens(String nom, String descritpion) {
		super(nom, descritpion, (Serviteur) serviteur);
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

		for(int i=1; i<=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu().size(); i++) {
			Plateau.plateau().getJoueurCourant().getJeu().add(serviteur);
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
