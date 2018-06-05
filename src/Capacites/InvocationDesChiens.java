package Capacites;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*propre à Rexxar, de la famille des 		
*invocations de serviteurs. Lorsqu'une 		
*carte possédant cette capacité est 		
*mise en jeu, des serviteurs chiens sont 	
*créés. Il y a autant de chiens que le 		
*joueur adverse a de serviteurs. Un 		
*chien est un serviteur +1/+1 avec 			
*Charge"
*@see InvocationDeServiteurs
*@authorCorentin/Clement
*/
public class InvocationDesChiens extends InvocationDeServiteurs{

	private static ICarte serviteur = new Serviteur("Chien", 0, 1, 1, new Charge("charge", "permet d'attaquer des le premier tour"), true);
	
	public InvocationDesChiens(String nom, String descritpion) {
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
	*compte le nombre de serviteurs 			
	*adverse et invoque en consequence 
	*les nouveaux serviteurs
	*@param cible la cible a atteindre
	*@throws HearthstoneException si pas 	
	*de cible ou si m’adversaire ne possède 	
	*pas la cible
	*@authorCorentin/Clement
	*/

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {

		for(int i=1; i<=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu().size(); i++) {
			Plateau.plateau().getJoueurCourant().getJeu().add(serviteur);
		}
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
