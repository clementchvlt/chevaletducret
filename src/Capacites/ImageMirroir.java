package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

public class ImageMirroir extends InvocationDeServiteurs{

	private static ICarte serviteur = new Serviteur("Serviteur de Jaina", 0, 2, 0, new Provocation ("provocation", "oblige à attaquer les serviteurs en vie avant le héros"), false);
	
	public ImageMirroir(String nom, String descritpion) {
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
		if(Plateau.plateau().getJoueurCourant().getHeros().getNom() == "Jaina") {
			Plateau.plateau().getJoueurCourant().getJeu().add(serviteur);
			Plateau.plateau().getJoueurCourant().getJeu().add(serviteur);
		}else throw new HearthstoneException("Le héros n'est pas Jaina");
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
