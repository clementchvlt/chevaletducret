
public class Sorts extends Carte {

	private String capacite;
	
	public Sorts(IJoueur proprietaire, String nom, int cout, String capacite) {
		super(nom, cout, proprietaire);
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
		
		return "Sort[Proprietaire=" + getProprietaire() + "Nom=," + getNom() + ", Prix=" + getCout() + ", Capacite" + getCapacite() + "]";
		
	}


}
