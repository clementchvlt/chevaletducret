package Carte;

import Application.HearthstoneException;
import Joueur.IJoueur;

public class Carte implements ICarte{
	private String nom;
	private int prix;
	private IJoueur proprietaire;
	
	public Carte (String nom, int prix, IJoueur proprietaire) {
		setNom(nom);
		setCout(prix);
		setProprietaire(proprietaire);
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
		
		
		@Override
		public void executerEffetDebutTour(Object cible) throws HearthstoneException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void executerEffetFinTour(Object cible) throws HearthstoneException {
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
		
}
