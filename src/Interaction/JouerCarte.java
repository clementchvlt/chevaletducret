package Interaction;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

public class JouerCarte extends Interaction{
	
	public final static Console console = new Console();

	public JouerCarte(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Traiter(Object o) {
		Object cible = null;
		ICarte carte = null;
		ICarte carteCible;
		int choix2;
		String choix3;
		System.out.println("Quelle carte jouer ? (un bout de son nom)\n");
		String choix = console.readLine();
		try {
			carte = Plateau.plateau().getJoueurCourant().getCarteEnMain(choix);
			if(carte instanceof Serviteur) {
				Plateau.plateau().getJoueurCourant().jouerCarte(carte);
			}else {
				System.out.println("Quelle est la cible ?\n");
				
				System.out.println("Quelle est votre cible ?\n");
				System.out.println("1. Le héros\n");
				System.out.println("2. Une autre carte\n");
				
				choix2 = console.readInt();
				
				if(choix2==1) {
					cible= Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros();      
					Plateau.plateau().getJoueurCourant().jouerCarte(carte, cible);
				}else if(choix2==2) {
					System.out.println("Veuillez donner plus d'infos sur la cible (un bout de son nom)\n");
					choix3 = console.readLine();
					try {
						carteCible= Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(choix3);
						Plateau.plateau().getJoueurCourant().jouerCarte(carte, carteCible);
					}catch (HearthstoneException e) {
						e.printStackTrace();
					}
				}
			}
			
				
			
		}
		catch(HearthstoneException e)
		{
		
		}
	
	}
}

