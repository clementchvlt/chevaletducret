package Application;	
import java.util.ArrayList;

import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Joueur.IJoueur;
import Joueur.Joueur;
import Capacites.ICapacite;
import Capacites.InvocationdDeServiteurs;
import Capacites.Provocation;
import Capacites.AttaqueCiblee;
import Capacites.AttaqueDuHeros;
import Capacites.Capacite;
import Capacites.EffetPermanent;
import Carte.Sorts;

public class Main {
	public static void main(String[] args) {
		
		ICapacite CriGuerre = new InvocationdDeServiteurs("Cri de guerre", "Invocation d'un serviteur +1/ +1");
		ICapacite Charge = new Capacites.Charge("Charge", null);
		ICapacite AttaqueMent= new AttaqueDuHeros("Attaque mentale", "inflige 5 points de degats au heros");
		ICapacite BonusHurlevent= new EffetPermanent("Bonus de hurlevent", "Effet permanent sur les autres serviteurs alliés donant un bonus +1/+1");
		ICapacite BonusChefRaid = new EffetPermanent("Bonus du chef de raid", "Effet permanant sur les autres serviteurs alliés de +1/0");
		ICapacite Provocation = new Provocation("Provocation", null);
		ICapacite AttaqueLepreux= new AttaqueCiblee("Attaque du lepreux", "Inflige 2");
		ICapacite Golemisation = new InvocationdDeServiteurs("Golemisation", "invoque un golem endomage +2/+1 qui n'a aucune capacite");
		
		Heros h= new Heros("Jaina",15, CriGuerre,true);
		int x=1;
		int y=x;
		
		ArrayList<ICarte> deckJ1= new ArrayList<ICarte>();
		ArrayList<ICarte> mainJ1= new ArrayList<ICarte>();
		ArrayList<ICarte> jeuJ1= new ArrayList<ICarte>();
		IJoueur J1 = null;
		try {
			J1 = new Joueur("Joueur1",deckJ1,mainJ1, jeuJ1, h,x, y );
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ICapacite C = new EffetPermanent("EffetPermanent", "fait durer l'odeur");
		ICarte main= new Serviteur (J1,"bitebitebite", 2, 8, 4, C, false);
		ICarte carte= new Serviteur(J1,"chatechatechate", 2, 4, 5, C, false);
		ICarte carte2= new Sorts(J1, "pet de Coco", 6, C);
		jeuJ1.add(carte);
		deckJ1.add(carte);
		deckJ1.add(carte2);
		mainJ1.add(main);
		
		/*for(ICarte i:deck) {
			System.out.println(i);
		}*/
		
		ArrayList<ICarte> bite = J1.getMain();
		for(ICarte i: bite) {
			System.out.println(i);
		}
		
		ArrayList<ICarte> test = J1.getJeu();
		for(ICarte j: test) {
			System.out.println(j);
		}
		
		ICarte tt= J1.getCarteEnMain("biet");
		System.out.println(tt);
		
		
		
/*
		System.out.println(h.toString());
		Heros g=new Heros("Rexxar",15, "are");
		System.out.println(g.toString());
		Serviteur s= new Serviteur ("clem",  69, 69, 69);
		System.out.println(s.toString());
		Serviteur z= new Serviteur ("clem",  69, 69, 69);
		System.out.println(z.toString());
		if (s.equals(z))
			System.out.println("c les mï¿½mes");
		else
			System.out.println("c pas les mï¿½mes");
	
		Sorts sort= new Sorts(null, "zaret", 70, "ezrt");
		System.out.println(sort.toString());
		
	*/
	}
}