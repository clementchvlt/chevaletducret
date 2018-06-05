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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((capacite == null) ? 0 : capacite.hashCode());
			result = prime * result + ((nom == null) ? 0 : nom.hashCode());
			result = prime * result + prix;
			result = prime * result + ((proprietaire == null) ? 0 : proprietaire.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Carte other = (Carte) obj;
			if (capacite == null) {
				if (other.capacite != null)
					return false;
			} else if (!capacite.equals(other.capacite))
				return false;
			if (nom == null) {
				if (other.nom != null)
					return false;
			} else if (!nom.equals(other.nom))
				return false;
			if (prix != other.prix)
				return false;
			if (proprietaire == null) {
				if (other.proprietaire != null)
					return false;
			} else if (!proprietaire.equals(other.proprietaire))
				return false;
			return true;
		}
		
		
}
