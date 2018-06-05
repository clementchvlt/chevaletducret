package Interaction;

import Application.HearthstoneException;

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
	
	public void interagir(Object actionDemandees, Object o) throws HearthstoneException {
		if(peutTraiter(actionDemandees)) {
			Traiter(o);
		}else if (suivant != null)
			suivant.interagir(actionDemandees,o);
		else
			throw new HearthstoneException("Il n'existe aucune interaction pour "+actionDemandees);
	}
}
