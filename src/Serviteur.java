

public class Serviteur extends Carte{
	
	private int vie, attaque;
	
	public Serviteur( IJoueur proprietaire ,String nom, int cout, int vie, int attaque) {
		super(nom, cout, proprietaire);
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
		return "Serviteur[Proprietaire=" + this.getProprietaire() + ", Nom=" + this.getNom() + ", Cout=" + getCout() + ", Vie=" + getVie() + ", Attaque=" + getAttaque() + "]";
	}

	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Serviteur)) throw new IllegalArgumentException();
		
		Serviteur s=(Serviteur)o;
		if((s.getNom().equals(this.getNom())) && (s.getCout()== this.getCout()) && (s.getVie() == this.getVie()) && (s.getAttaque() == this.getAttaque())  && (s.getProprietaire()== this.getProprietaire()) )return true;
		return false;
	}
	
}