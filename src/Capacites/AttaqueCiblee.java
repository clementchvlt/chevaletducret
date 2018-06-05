package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Plateau.Plateau;

/**
*Classe pour les attaques avec cible 
*see Capacite
*@authorCorentin/Clement
*/

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

	/**
	*enleve le nombre de points de 	
	*l’attaque aux pv du héros ou du 
	*joueur adverse
	*@param cible la cible a atteindre
	*@throws HearthstoneException si pas 		
	*de cible ou si m’adversaire ne possède 	
	*pas la cible
	*@authorCorentin/Clement
	*/
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		executerAction(cible);
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
