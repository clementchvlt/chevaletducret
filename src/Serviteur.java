

public class Serviteur extends Carte{
	
	private int vie, attaque;
	
	public Serviteur(String nom, int prix, int vie, int attaque) {
		super(nom, prix);
		setVie(vie);
		setAttaque(attaque);
		// TODO Auto-generated constructor stub
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	public String toString(){
		return "Serviteur[Nom=" + this.getNom() + ", Prix=" + getPrix() + ", Vie=" + getVie() + ", Attaque=" + getAttaque() + "]";
	}

	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Serviteur)) throw new IllegalArgumentException();
		
		Serviteur s=(Serviteur)o;
		if((s.getNom().equals(this.getNom())) && (s.getPrix()== this.getPrix()) && (s.getVie() == this.getVie()) && (s.getAttaque() == this.getAttaque()) )return true;
		return false;
	}
	
}