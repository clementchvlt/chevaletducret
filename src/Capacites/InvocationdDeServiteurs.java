package Capacites;

import Application.HearthstoneException;
import Carte.Serviteur;

public class InvocationdDeServiteurs extends Capacite{
	private Serviteur serviteur;
	public InvocationdDeServiteurs(String nom, String descritpion, Serviteur serviteur) {
		super(nom, descritpion);
		this.serviteur=serviteur;
		
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
