package Interaction;

import Application.HearthstoneException;
import Plateau.Plateau;

public class Quitter extends Interaction{
	
	public final static Console console = new Console();
	
	public Quitter(Interaction pSuivant) {
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
		String choix;
		System.out.println("Voulez vous abandonner ? (o ou n)");
		choix = console.readLine();
		if(choix.contentEquals("o") || choix.contentEquals("O")) {
			try {
				Plateau.plateau().gagnePartie(Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()) );
			} catch (HearthstoneException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		else if(choix.contentEquals("n") || choix.contentEquals("N"))
			return;
		
	}
}
