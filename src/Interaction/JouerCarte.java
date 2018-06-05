package Interaction;

import Application.HearthstoneException;
import Carte.ICarte;
import Carte.Serviteur;
import Plateau.Plateau;

/**
*Classe  permettant de jouer une carte de la main
*see Interaction
*@authorCorentin/Clement
*/

public class JouerCarte extends Interaction{
	
	public final static Console console = new Console();

	public JouerCarte(Interaction pSuivant) {
		super(pSuivant);
		// TODO Auto-generated constructor stub
	}

	/**
	*Retourne true si la description de l'interaction et l'entree clavier correspondent bien
	*@return boolean
	*@param actionDemandee
	*@authorCorentin/Clement
	*/

	@Override
	public boolean peutTraiter(Object actionDemandee) {
		return getDescription().equals(actionDemandee);
	}

	/**
	*Methode qui permet de traiter la demande de l'utilisateur, ici, Jouer une carte de sa main
	*@param o
	*@authorCorentin/Clement
	*/

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
					//Plateau.plateau().getJoueurCourant().jouerCarte(carte, cible);
					carte.executerAction(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros());
				}else {
					System.out.println("Veuillez donner plus d'infos sur la cible (un bout de son nom)\n");
					choix3 = console.readLine();
					try {
						carteCible= Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(choix3);
						//Plateau.plateau().getJoueurCourant().jouerCarte(carte, carteCible);
						carte.executerAction(carteCible);
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

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Jouer carte";
	}
}

