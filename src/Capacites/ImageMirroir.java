package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*Classe de la capacite image miroir qui 	
*est propre a Jaina: la carte poss�dant 	
*cette capacit� invoque 					
*automatiquement, au d�but du tour, 		
*deux serviteurs 0/+2 avec la capacit� 		
* Provocation"
*@see capacite
*@authorCorentin/Clement
*/
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

	/**
	*enleve le nombre de points de 	
	*l�attaque aux pv du h�ros ou du 
	*joueur adverse
	*@param cible la cible a atteindre
	*@throws HearthstoneException le 		
	*heros n�est pas Jaina
	*@authorCorentin/Clement
	*/

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
