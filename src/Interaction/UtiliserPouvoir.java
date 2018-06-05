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
		return getDescription().equals(actionDemandee);
	}

	@Override
	public void Traiter(Object o) {
		int choix = 0;
		Object cible =null;
		try {
			if(Plateau.plateau().getJoueurCourant().getHeros().pouvoirUtlisable()) {
				try {
					cible=Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getHeros();
					Plateau.plateau().getJoueurCourant().utiliserPouvoir(cible);
				} catch (HearthstoneException e) {
					
					e.printStackTrace();
				}
				Plateau.plateau().getJoueurCourant().getHeros().setPouvoirUtilisable(false);
			}else throw new HearthstoneException("Le pouvoir a deja ete utilise");
		} catch (HearthstoneException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
