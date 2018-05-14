
public class Sorts extends Carte {

	private String capacite;
	
	public Sorts(String nom, int prix, String capacite) {
		super(nom, prix);
		setCapacite(capacite);
		// TODO Auto-generated constructor stub
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public String toString() {
		
		return "Sort[Nom=," + getNom() + ", Prix=" + getPrix() + ", Capacite" + getCapacite() + "]";
		
	}


}
