package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

public class EffetPermanent extends Capacite{

	private int bonusAttaque;
	private int bonusVie;
	
	public EffetPermanent(String nom, String descritpion, int bonusAttaque, int bonusVie) {
		super(nom, descritpion);
		this.bonusAttaque=bonusAttaque;
		this.bonusVie=bonusVie;
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
		for(ICarte c : Plateau.plateau().getJoueurCourant().getJeu() ) {
			
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setAttaque(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getAttaque()+this.bonusAttaque);
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setVie(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getVie()+this.bonusVie);
		
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		for(ICarte c : Plateau.plateau().getJoueurCourant().getJeu() ) {
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setAttaque(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getAttaque()-this.bonusAttaque);
			((Serviteur) Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom())).setVie(Plateau.plateau().getJoueurCourant().getCarteEnJeu((String) c.getNom()).getVie()-this.bonusVie);
			
		}
	}
}
