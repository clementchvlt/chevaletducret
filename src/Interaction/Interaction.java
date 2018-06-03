package Interaction;

public abstract class Interaction {
	private Interaction suivant;
	
	public Interaction(Interaction pSuivant) {
        suivant = pSuivant;
    }
	
	public Interaction getSuivant() {
		return suivant;
	}
	
	public abstract boolean	peutTraiter(Object actionDemandee);
	public abstract void Traiter(Object o);
}
