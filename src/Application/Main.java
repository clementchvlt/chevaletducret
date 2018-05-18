package Application;
import java.util.ArrayList;

import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Joueur.IJoueur;
import Joueur.Joueur;

public class Main {
	public static void main(String[] args) {
		Heros h= new Heros("Jaina",15, "aezrf");
		
		ArrayList<ICarte> deck= new ArrayList<ICarte>();
		ArrayList<ICarte> main= new ArrayList<ICarte>();		
		IJoueur J = null;
		try {
			J = new Joueur("alex",deck,main, h,2 );
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ICarte carte= new Serviteur(J,"ezraabvds", 2, 4, 5);

		deck.add(carte);
		
		System.out.println(carte);
		
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