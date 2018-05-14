

public class Carte {
	private String nom;
	private int prix;
	
	public Carte(String nom, int prix) {
		setNom(nom);
		setPrix(prix);
	}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getPrix() {
			return prix;
		}
		public void setPrix(int prix) {
			this.prix = prix;
		}

}
