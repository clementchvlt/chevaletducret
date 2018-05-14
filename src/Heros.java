


public class Heros{
	private String nom;
	private int vie=15;
	private String pouvoir;
	
	public Heros (String nom,int vie,String pouvoir) {
		setNom(nom);
		setVie(vie);
		setPouvoir(pouvoir);
	}

	private void setPouvoir(String pouvoir) {
		this.pouvoir=pouvoir;
		
	}

	private void setVie(int vie) {
		this.vie=vie;
	}

	private void setNom(String nom) {
		this.nom=nom;
		
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getVie() {
		return this.vie;
	}
	
	public String getPouvoir() {
		return this.pouvoir;
	}
	
	public String toString() {
		return "Hero[nom="+this.getNom()+",Vie="+this.getVie()+",Pouvoir="+this.getPouvoir()+"]";
	}
	
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Heros)) throw new IllegalArgumentException();
		
		Heros h=(Heros)o;
		if(h.getNom().equals(this.nom)&&(h.getVie()==this.vie)&&(h.getPouvoir()==this.pouvoir))return true;
		return false;
	}
	
}