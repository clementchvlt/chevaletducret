package Interaction;

import Application.HearthstoneException;
import Joueur.IJoueur;
import Plateau.Plateau;

public class FinirLeTour extends Interaction{

	public FinirLeTour(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		return getDescription().equals(actionDemandee);
	}

	@Override
	public void Traiter(Object o) {
		IJoueur fcourant;
		try {
			Plateau.plateau().finTour(Plateau.plateau().getJoueurCourant());
			fcourant =Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant());
			Plateau.plateau().setAdversaire(Plateau.plateau().getJoueurCourant());
			Plateau.plateau().setJoueurCourant(fcourant);
			Plateau.plateau().getJoueurCourant().piocher();
		} catch (HearthstoneException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Finir le tour";
	}

}
