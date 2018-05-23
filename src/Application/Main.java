package Application;	
import java.util.ArrayList;

import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Joueur.IJoueur;
import Joueur.Joueur;
import Capacites.ICapacite;
import Capacites.Capacite;
import Capacites.EffetPermanent;
import Carte.Sorts;

public class Main {
	public static void main(String[] args) {
		Heros h= new Heros("Jaina",15, "aezrf");
		int x=1;
		int y=x;
		
		ArrayList<ICarte> deck= new ArrayList<ICarte>();
		ArrayList<ICarte> main= new ArrayList<ICarte>();
		ArrayList<ICarte> jeu= new ArrayList<ICarte>();
		IJoueur J = null;
		try {
			J = new Joueur("alex",deck,main, jeu, h,x, y );
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ICapacite C = new EffetPermanent("EffetPermanent", "fait durer l'odeur");
		ICarte main1= new Serviteur (J,"bitebitebite", 2, 8, 4, C);
		ICarte carte= new Serviteur(J,"chatechatechate", 2, 4, 5, C);
		ICarte carte2= new Sorts(J, "pet de Coco", 6, C);
		jeu.add(carte);
		deck.add(carte);
		deck.add(carte2);
		main.add(main1);
		
		/*for(ICarte i:deck) {
			System.out.println(i);
		}*/
		
		ArrayList<ICarte> bite = J.getMain();
		for(ICarte i: bite) {
			System.out.println(i);
		}
		
		ArrayList<ICarte> test = J.getJeu();
		for(ICarte j: test) {
			System.out.println(j);
		}
		
		ICarte tt= J.getCarteEnMain("biet");
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
			System.out.println("c les m�mes");
		else
			System.out.println("c pas les m�mes");
	
		Sorts sort= new Sorts(null, "zaret", 70, "ezrt");
		System.out.println(sort.toString());
		
	*/
	}
}