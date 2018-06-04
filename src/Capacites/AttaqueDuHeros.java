package Capacites;

import Application.HearthstoneException;
import Heros.Heros;
import Plateau.Plateau;

public class AttaqueDuHeros extends Capacite{
	private int attaque;

	public AttaqueDuHeros(String nom, String descritpion,int attaque) {
		super(nom, descritpion);
		this.attaque=attaque;
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
		if(!(cible instanceof Heros)) {
			throw new HearthstoneException("La cible n'est pas un héros");
		}else {
			Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().setVie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().getVie()-attaque);
			int vie= Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().getVie();
			if(vie<=0) {
				Plateau.plateau().gagnePartie(Plateau.plateau().getJoueurCourant());
			}
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
