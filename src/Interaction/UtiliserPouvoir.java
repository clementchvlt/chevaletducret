package Interaction;

import Application.HearthstoneException;
import Plateau.Plateau;

public class UtiliserPouvoir extends Interaction{

	public final static Console console = new Console();
	
	
	public UtiliserPouvoir(Interaction pSuivant) {
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
		int choix = 0;
		Object cible =null;
		String choix2;
		
		System.out.println("Quelle est votre cible ?\n");
		System.out.println("1. Le héros\n");
		System.out.println("2. Une autre carte\n");
		choix = console.readInt();

		if(choix==1) {
			try {
				cible=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros();
			} catch (HearthstoneException e) {
				
				e.printStackTrace();
			}
		}else if(choix==2) {
			System.out.println("Quelle carte visez-vous ?");
			choix2 = console.readLine();
			try {
				cible = Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getCarteEnJeu(choix2);
			}
			catch(HearthstoneException e)
			{
				e.printStackTrace();
			}
		}
		
		try {
			Plateau.plateau().getJoueurCourant().utiliserPouvoir(cible);
		}catch(HearthstoneException e) {
			e.printStackTrace();
		}

}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Utiliser pouvoir du heros";
	}
}
