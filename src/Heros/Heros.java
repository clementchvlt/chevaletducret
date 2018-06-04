package Heros;

import Capacites.ICapacite;

public class Heros{
	private String nom;
	private int vie=15;
	private ICapacite pouvoir;
	private boolean pouvoirUtilisable = true;
	
	public Heros (String nom,int vie,ICapacite pouvoir, boolean pouvoirUtilisable) {
		setNom(nom);
		setVie(vie);
		setPouvoir(pouvoir);
		setPouvoirUtilisable(pouvoirUtilisable);
	}
	
	public void setPouvoirUtilisable(boolean pouvoirUtilisable) {
		this.pouvoirUtilisable=pouvoirUtilisable;
	}
	public boolean pouvoirUtlisable() {
		return pouvoirUtilisable;
	}
	
	private void setPouvoir(ICapacite pouvoir) {
		this.pouvoir=pouvoir;
		
	}

	public void setVie(int vie) {
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
	
	public ICapacite getPouvoir() {
		return this.pouvoir;
	}
	
	public String toString() {
		return "Hero[Nom="+this.getNom()+", Vie="+this.getVie()+", Pouvoir="+this.getPouvoir()+"]";
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