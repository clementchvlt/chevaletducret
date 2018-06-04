package Interaction;

import Application.HearthstoneException;
import Plateau.Plateau;

public class FinirLeTour extends Interaction{

	public FinirLeTour(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Traiter(Object o) {
		try {
			Plateau.plateau().finTour(Plateau.plateau().getJoueurCourant());
		} catch (HearthstoneException e) {
			
			e.printStackTrace();
		}
		
	}

}
