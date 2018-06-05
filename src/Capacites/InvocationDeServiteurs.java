package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*la carte qui possède cette capa cree 		
*des sa mise en jeu un serviteur
*@see Capcite
*@authorCorentin/Clement
*/
public class InvocationDeServiteurs extends Capacite{
	private Serviteur serviteur;
	public InvocationDeServiteurs(String nom, String descritpion, Serviteur serviteur1) {
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
		Plateau.plateau().getJoueurCourant().getJeu().add(this.serviteur);
		
	}
	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
