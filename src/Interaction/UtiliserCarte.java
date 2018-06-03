package Interaction;

import Application.HearthstoneException;
import Carte.ICarte;
import Plateau.Plateau;

public class UtiliserCarte extends Interaction{

	public final static Console console = new Console();
	
	public UtiliserCarte(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		return false;
	}

	@Override
	public void Traiter(Object o) {
		ICarte carte;
		Plateau plateau = null;
		int cible;
		System.out.println("Quelle carte jouer ? (un bout de son nom)");
		String choixCarte = console.readLine();
		try {
			carte= plateau.getJoueurCourant().getCarteEnMain(choixCarte);
			cible=0;
			
			System.out.println("Quelle est votre cible ?\n");
			System.out.println("1. Le héros\n");
			System.out.println("2. Une autre carte\n");
			cible = console.readInt();
			
			
		}catch(HearthstoneException e) {
			
		}
		
	}
	

}
