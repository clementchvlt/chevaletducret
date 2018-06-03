package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;

public class InvocationdDeServiteurs extends Capacite{
	private ICarte serviteur;
	public InvocationdDeServiteurs(String nom, String descritpion, ICarte serviteur1) {
		super(nom, descritpion);
		this.serviteur=serviteur1;
		
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
