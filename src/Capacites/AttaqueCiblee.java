package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Plateau.Plateau;

public class AttaqueCiblee extends Capacite {
	private int attaque;

	public AttaqueCiblee(String nom, String descritpion, int attaque) {
		super(nom, descritpion);
		this.attaque=attaque;
	}
	
	public int getAttaque() {
		return this.attaque;
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
		if(cible==null) {
			throw new HearthstoneException("La cible est vide");
		}
		if(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).aProvoc()){
			throw new HearthstoneException("L'adversaire possede une carte avec provocation");
		}else if(cible instanceof Heros) {
			Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().setVie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().getVie()-attaque);
			int vie= Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().getVie();
			if(vie<=0) {
				Plateau.plateau().gagnePartie(Plateau.plateau().getJoueurCourant());
			}
		}else if(cible instanceof Serviteur) {
			if(attaque>=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu((String) cible).getVie()) {
				Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).perdreCarte((ICarte) cible);
			}else {
				((Serviteur) Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu((String) cible)).setVie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu((String) cible).getVie()-attaque);
			}
				
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
