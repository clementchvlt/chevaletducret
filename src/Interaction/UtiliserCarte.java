package Interaction;

import Application.HearthstoneException;
import Carte.ICarte;
import Plateau.Plateau;

/**
*Classe permettant d'utiliser une carte du jeu
*see Interaction
*@authorCorentin/Clement
*/
public class UtiliserCarte extends Interaction{

	public final static Console console = new Console();
	
	public UtiliserCarte(Interaction pSuivant) {
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
	*Methode qui permet de traiter la demande de l'utilisateur, ici, utiliser une carte du jeu
	*@authorCorentin/Clement
	*/
	@Override
	public void Traiter(Object o) {
		ICarte carte;
		ICarte carte2;
		int cible;
		String choixCarte2;
		Object obj;
		System.out.println("Quelle carte utiliser ? (un bout de son nom)");
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
				/*Plateau.plateau().getJoueurCourant().utiliserCarte(carte, obj);*/
				Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().setVie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros().getVie()-carte.getAttaque());;
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

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Utiliser carte";
	}
	

}
