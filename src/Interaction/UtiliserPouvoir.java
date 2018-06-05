package Interaction;

import Application.HearthstoneException;
import Plateau.Plateau;

/**
*Classe permettant d'utiliser le pouvoir du heros
*see Interaction
*@authorCorentin/Clement
*/
public class UtiliserPouvoir extends Interaction{

	public final static Console console = new Console();
	
	
	public UtiliserPouvoir(Interaction pSuivant) {
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
	*Methode qui permet de traiter la demande de l'utilisateur, ici, utiliser le pouvoir du heros
	*@authorCorentin/Clement
	*/
	@Override
	public void Traiter(Object o) {
		int choix = 0;
		Object cible =null;
		
				try {
						cible=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros();
						Plateau.plateau().getJoueurCourant().utiliserPouvoir(cible);
						Plateau.plateau().getJoueurCourant().getHeros().setPouvoirUtilisable(false);
				} catch (HearthstoneException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			
}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Utiliser pouvoir du heros";
	}
}
