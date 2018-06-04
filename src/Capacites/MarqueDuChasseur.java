package Capacites;

import Application.HearthstoneException;
import Carte.Serviteur;
import Plateau.Plateau;

public class MarqueDuChasseur extends Capacite{

	public MarqueDuChasseur(String nom, String descritpion) {
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
		if(cible == null)
			throw new HearthstoneException("La cible est nulle like u");
		if(cible instanceof Serviteur) {
			if(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu().contains((Serviteur) cible))
				((Serviteur) Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(((Serviteur) cible).getNom())).setVie(1);
			else throw new HearthstoneException("La cible est comme Benzema pendant la coupe du Monde...");
		}
		else
			throw new HearthstoneException("La cible n'est pas un serviteur");
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
