package Carte;

import Application.HearthstoneException;
import Capacites.ICapacite;
import Joueur.IJoueur;

public abstract class Carte implements ICarte{
	private String nom;
	private int prix;
	private IJoueur proprietaire;
	private ICapacite capacite;
	
	public Carte (String nom, int prix, IJoueur proprietaire, ICapacite capacite) {
		setNom(nom);
		setCout(prix);
		setProprietaire(proprietaire);
		setCapacite(capacite);
	}
		private void setCapacite(ICapacite capacite) {
		// TODO Auto-generated method stub
		this.capacite=capacite;
	}
		private void setProprietaire(IJoueur proprietaire) {
			this.proprietaire=proprietaire;
		
		}
		public IJoueur getProprietaire() {
			return proprietaire;
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
