package Interaction;

import Application.HearthstoneException;

/**
*Classe qui permet d'interagir avec le joueur
*@authorCorentin/Clement
*/
public abstract class Interaction {
	private Interaction suivant;
	
	public Interaction(Interaction pSuivant) {
        suivant = pSuivant;
    }
	
	public Interaction getSuivant() {
		return suivant;
	}
	
	public abstract String getDescription();
	public abstract boolean	peutTraiter(Object actionDemandee);
	public abstract void Traiter(Object o);
	
	
	/**
	*Permet d'executer la demande du joueur
	*source https://rpouiller.developpez.com/tutoriel/java/design-patterns-gang-of-four/?page=page_4#LVI
	*@param actionDemandee
	*@param o
	*@throws HearstoneException si pas 		
	*d’interaction
	*@authorCorentin/Clement
	*/
	public void interagir(Object actionDemandees, Object o) throws HearthstoneException {
		if(peutTraiter(actionDemandees)) {
			Traiter(o);
		}else if (suivant != null)
			suivant.interagir(actionDemandees,o);
		else
			throw new HearthstoneException("Il n'existe pas d'nteraction pour "+actionDemandees);
	}
}
