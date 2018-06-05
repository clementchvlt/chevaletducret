package Capacites;

import Application.HearthstoneException;

/**
*Classe générale des capacite, 			
*construit le nom et la description 
*@authorCorentin/Clement
*/
public abstract class Capacite implements ICapacite{
	private String nom, description;
	public Capacite (String nom, String description) {
		setNom(nom);
		setDescription(description);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		
		return "Capacite[Nom=" + getNom() + ", Description=" + getDescription() + "]";
		
	}
	

	
}
