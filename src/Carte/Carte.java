package Carte;

import Application.HearthstoneException;
import Capacites.ICapacite;
import Joueur.IJoueur;


/**
	*Classe carte de laquelle heritent serviteur et sorts
	*@author Corentin/Clement
	*/


public abstract class Carte implements ICarte{
	private String nom;
	private int prix;
	private IJoueur proprietaire;
	private ICapacite capacite;
	
	public Carte (String nom, int prix, ICapacite capacite) {
		setNom(nom);
		setCout(prix);
		setCapacite(capacite);
	}
		private void setCapacite(ICapacite capacite) {
		// TODO Auto-generated method stub
		this.capacite=capacite;
	}
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getCout() {
			return prix;
		}
		public void setCout(int prix) {
			this.prix = prix;
		}
		
		public ICapacite getCapacite() {
			return capacite;
		}
		
		
}
