

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

}
