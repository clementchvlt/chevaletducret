package Interaction;

import Application.HearthstoneException;
import Joueur.IJoueur;
import Plateau.Plateau;

/**
*Classe qui permet de finir le tour actuel 
*see Interaction
*@authorCorentin/Clement
*/
public class FinirLeTour extends Interaction{

	public FinirLeTour(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	/**
	*Retourne true si la description de l'interaction et l'entree clavier correspondent bien
	*@return boolean 
	*@param actionDemandee
	*@authorCorentin/Clement
	*/

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		return getDescription().equals(actionDemandee);
	}
	
	/**
	*Methode qui permet de traiter la demande de l'utilisateur, ici, Finir le tour
	*@param o      //le plateau
	*@authorCorentin/Clement
	*/
	@Override
	public void Traiter(Object o) {
		IJoueur fcourant;
		try {
			Plateau.plateau().finTour(Plateau.plateau().getJoueurCourant());
			fcourant =Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant());
			Plateau.plateau().setAdversaire(Plateau.plateau().getJoueurCourant());
			Plateau.plateau().setJoueurCourant(fcourant);
			Plateau.plateau().getJoueurCourant().piocher();
			Plateau.plateau().getJoueurCourant().setMana(Plateau.plateau().getJoueurCourant().getMana()+1);
			Plateau.plateau().getJoueurCourant().setStockMana(Plateau.plateau().getJoueurCourant().getMana());
		} catch (HearthstoneException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Finir le tour";
	}

}
