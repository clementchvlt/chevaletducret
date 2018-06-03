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
		ICarte carte2;
		int cible;
		String choixCarte2;
		Object obj;
		System.out.println("Quelle carte jouer ? (un bout de son nom)");
		String choixCarte = console.readLine();
		try {
			carte= Plateau.plateau().getJoueurCourant().getCarteEnMain(choixCarte);
			cible=0;
			
			System.out.println("Quelle est votre cible ?\n");
			System.out.println("1. Le héros\n");
			System.out.println("2. Une autre carte\n");
			cible = console.readInt();
			
			if(cible == 1) {
				obj=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros();
				Plateau.plateau().getJoueurCourant().utiliserCarte(carte, obj);
			}else if(cible == 2) {
				System.out.println("Quelle carte tu veux attaquer (donne un boout de son nom\n");
				choixCarte2= console.readLine();
				try {
					carte2=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(choixCarte2);
					
					Plateau.plateau().getJoueurCourant().utiliserCarte(carte, carte2);
				}catch(HearthstoneException e) {
					e.printStackTrace();
				}
			}
			
			
		}catch(HearthstoneException e) {
			e.printStackTrace();
		}
		
	}
	

}
