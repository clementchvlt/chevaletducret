package Interaction;

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
	
	public void interagir(Object actionDemandees, Object o) throws Exception {
		if(peutTraiter(actionDemandees)) {
			Traiter(o);
		}else if (suivant != null)
			suivant.interagir(actionDemandees,o);
		else
			throw new Exception("Il n'existe aucune interaction pour "+actionDemandees);
	}
}
