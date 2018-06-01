package Carte;

import Application.HearthstoneException;
import Capacites.ICapacite;
import Joueur.IJoueur;

public class Carte implements ICarte{
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
		
		
		@Override
		public void executerEffetDebutTour(Object cible) throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void executerEffetFinTour() throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void executerEffetDisparition(Object cible) throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void executerAction(Object cible) throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean disparait() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean getPeutAttaquer() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void setPeutAttaquer(boolean peutAttaquer) {
			// TODO Auto-generated method stub
			
		}
		
}
