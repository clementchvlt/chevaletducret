package Application;	
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

import Carte.ICarte;
import Carte.Serviteur;
import Heros.Heros;
import Interaction.Console;
import Interaction.FinirLeTour;
import Interaction.Interaction;
import Interaction.JouerCarte;
import Interaction.UtiliserCarte;
import Interaction.UtiliserPouvoir;
import Joueur.IJoueur;
import Joueur.Joueur;
import Plateau.IPlateau;
import Plateau.Plateau;
import Capacites.ICapacite;
import Capacites.ImageMirroir;
import Capacites.InvocationDeServiteurs;
import Capacites.InvocationDesChiens;
import Capacites.MarqueDuChasseur;
import Capacites.Pioche;
import Capacites.Provocation;
import Capacites.AttaqueCiblee;
import Capacites.AttaqueDuHeros;
import Capacites.AttaqueTotale;
import Capacites.Capacite;
import Capacites.Charge;
import Capacites.EffetPermanent;
import Carte.Sorts;

public class Main {
	public static Interaction inter = null;
	public final static Console console = new Console();
	
	public static void main(String[] args) {
		int mana=0;
		int stockMana=0;
		
		
		ICapacite pouvoirJaina= new AttaqueCiblee("Boule de feu","inflige 1 point de degats a la cible",1);
		ICapacite pouvoirRexxar=new AttaqueCiblee("Tir assur�","inflige 2 degats au heros adverse",2);
		Heros Jaina = new Heros("Jaina",15,pouvoirJaina,false);
		Heros Rexxar= new Heros("Rexxar",15, pouvoirRexxar, false);
		
		System.out.println("Pseudo du premier joueur : ");
		String pseudo1 = console.readLine();
		
		System.out.println("Pseudo du deuxieme joueur : ");
		String pseudo2 = console.readLine();
		
		ArrayList<ICarte> deckJ= new ArrayList<ICarte>();
		ArrayList<ICarte> mainJ= new ArrayList<ICarte>();
		ArrayList<ICarte> jeuJ= new ArrayList<ICarte>();
		
		ArrayList<ICarte> deckR= new ArrayList<ICarte>();
		ArrayList<ICarte> mainR= new ArrayList<ICarte>();
		ArrayList<ICarte> jeuR= new ArrayList<ICarte>();
		
		
		IJoueur JoueurJ= new Joueur(pseudo1,deckJ, mainJ, jeuJ, Jaina, mana, stockMana) ;

		IJoueur JoueurR= new Joueur(pseudo2,deckR, mainR, jeuR, Rexxar, mana, stockMana) ;

		
		/*
		 * Creation des Capacites 
		 */
		
		ICarte serviteur1_1 = new Serviteur("serviteur1/1",0,1,1,null,false);
		ICarte serviteur2_1= new Serviteur("serviteur2/1", 0, 2, 1, null, false);
		ICapacite CriGuerre = new InvocationDeServiteurs("Cri de guerre", "Invocation d'un serviteur +1/ +1", (Serviteur) serviteur1_1);		
		ICapacite Charge = new Charge("Charge", null);
		ICapacite AttaqueMent= new AttaqueDuHeros("Attaque mentale", "inflige 5 points de degats au heros", 5);
		ICapacite BonusHurlevent= new EffetPermanent("Bonus de hurlevent", "Effet permanent sur les autres serviteurs alli�s donant un bonus +1/+1", 1, 1);
		ICapacite BonusChefRaid = new EffetPermanent("Bonus du chef de raid", "Effet permanant sur les autres serviteurs alli�s de +1/0", 1, 1);
		ICapacite Provocation = new Provocation("Provocation", null);
		ICapacite AttaqueLepreux= new AttaqueCiblee("Attaque du lepreux", "Inflige 2", 2);
		ICapacite Golemisation = new InvocationDeServiteurs("Golemisation", "invoque un golem endomage +2/+1 qui n'a aucune capacite",(Serviteur) serviteur2_1);
		ICapacite AttaqueMassive= new AttaqueTotale("Attaque massive","inflige 4 pts de degats a tout les serviteurs adverses", 4);
		ICapacite AttaqueGivre = new AttaqueCiblee("Attaque givre", " Inflige 3 pts de degats au personnage cible", 30);
		ICapacite Pioche1 = new Pioche("pioche","pioche une carte",1 );
		ICapacite Pioche2 = new Pioche("pioche","pioche 2 cartes",2);
		ICapacite ImageMiroir = new ImageMirroir("image miroir","invoque deux serviteurs de Jaina");
		ICapacite ExplosionPyro = new AttaqueCiblee("explosion pyrotechnique", "inflige 10 degats au personnage cible",10);
		ICapacite MarqueChasseur = new MarqueDuChasseur("Marque du chasseur", "Abaisse a 1 les pv du serviteur cible");
		ICapacite TirsArcanes = new AttaqueCiblee("tir des arcanes","inflige 2 degats a la cible",2);
		ICapacite InvocationChiens = new InvocationDesChiens("Invocation des chiens","invoque des chiens");
		ICapacite OrdreTuer = new AttaqueCiblee("Ordre de tuer", "Inflige 3 degats a la cible", 3);
		
		/*
		 * Creation des cartes neutres
		 */
		ICarte  ChasseMareeMurloc = new Serviteur("ChasseMareeMurloc ", 2, 1, 2, CriGuerre, false); 
		ICarte   ChampionDeHurlevent = new Serviteur(" ChampionDeUrlevent ", 7, 6, 6, BonusHurlevent, false); 
		ICarte   ChefDeRaid = new Serviteur(" ChefDeRaid ", 3, 2, 2, BonusChefRaid, false); 
		ICarte   GradeDeBaieDuButin = new Serviteur(" GradeDeBaieDuButin ", 5, 4, 5, Provocation, false); 
		ICarte   LaMissiliereTemeraire = new Serviteur(" LaMissiliereTemeraire ", 6, 2, 5, Charge, false); 
		ICarte   LogreMagi = new Serviteur(" LogreMagi ", 4, 4,4, Provocation, false); 
		ICarte   Archimage = new Serviteur(" Archimage ", 6, 7, 4, Provocation, false); 
		ICarte   GnomeLepreux = new Serviteur(" GnomeLepreux ", 1, 1, 1, AttaqueLepreux, false); 
		ICarte   Golem_moissons = new Serviteur(" Golem moissons ", 3, 3, 2, Golemisation, false); 
		ICarte   carteCharge = new Sorts("Charge",1,null); 
		ICarte   AttaqueMentale = new Sorts("AttaqueMentale ", 2, AttaqueMent); 

		/*
		 * Creation cartes speaciales Jaina
		 */
		
		ICarte   ChocDeFlmammes = new Sorts("ChocDeFlmammes ", 7, AttaqueMassive); 
		ICarte   EclairDeGivre = new Sorts("EclairDeGivre", 2, AttaqueGivre); 
		ICarte   IntelligenceDesArcanes = new Sorts(" IntelligenceDesArcanes ", 2, Pioche2); 
		ICarte   ImageMirroir = new Sorts(" ImageMirroir ", 1, ImageMiroir); 
		ICarte   ExplosionPyrotechnique = new Sorts(" ExplosionDesArcanes ", 10, ExplosionPyro); 

		/*
		 * Creation cartes speciales Rexxar
		 */
		ICarte   BusardAffame = new Serviteur( "BusardAffame ", 5,2,3, Pioche1, false); 
		ICarte   MarqueDuChasseur = new Sorts(" MarqueDuChasseur ", 1, MarqueChasseur); 
		ICarte   TirDesArcanes = new Sorts(" TirDesArcanes ", 1, TirsArcanes); 
		ICarte   LachezLesChies= new Sorts(" LachezLesChies ", 3, InvocationChiens); 
		ICarte   OrdreDeTuer = new Sorts(" OrdreDeTuer ", 3, OrdreTuer);
		
		deckR.add(BusardAffame);
		deckR.add(MarqueDuChasseur);
		deckR.add(TirDesArcanes);
		deckR.add(LachezLesChies);
		deckR.add(OrdreDeTuer);
		deckR.add(ChasseMareeMurloc);
		deckR.add(ChampionDeHurlevent);
		deckR.add(ChefDeRaid);
		deckR.add( GradeDeBaieDuButin);
		deckR.add(LaMissiliereTemeraire);
		deckR.add(LogreMagi);
		deckR.add(Archimage);
		deckR.add(GnomeLepreux);
		deckR.add(Golem_moissons);
		deckR.add(carteCharge);
		deckR.add(AttaqueMentale);
		
		deckJ.add( ChocDeFlmammes);
		deckJ.add(EclairDeGivre);
		deckJ.add(IntelligenceDesArcanes);
		deckJ.add(ImageMirroir);
		deckJ.add(ExplosionPyrotechnique);
		deckJ.add(ChasseMareeMurloc);
		deckJ.add(ChampionDeHurlevent);
		deckJ.add(ChefDeRaid);
		deckJ.add( GradeDeBaieDuButin);
		deckJ.add(LaMissiliereTemeraire);
		deckJ.add(LogreMagi);
		deckJ.add(Archimage);
		deckJ.add(GnomeLepreux);
		deckJ.add(Golem_moissons);
		deckJ.add(carteCharge);
		deckJ.add(AttaqueMentale);
		
		Collections.shuffle(deckJ);
		Collections.shuffle(deckR);
		
	
			/*mainJ.add(deckJ.get(i));
			deckJ.remove(i);
			mainR.add(deckR.get(i));
			deckR.remove(i);
			System.out.println(deckJ.get(i));*/
		
		ArrayList<IJoueur> listeJoueurs= new ArrayList<IJoueur>();
		
		try {
			Plateau.plateau().ajouterJoueur(JoueurR);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Plateau.plateau().ajouterJoueur(JoueurJ);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Plateau.plateau().demarrerPartie();
			System.out.println(Plateau.plateau().toString());
		} catch (HearthstoneException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		inter = initialiserInteractions();
		
		try {
			
			while(Plateau.plateau().estDemarree()) {
				String choix = menu();
				System.out.println(choix);

					try {
						
						/*try {
							Plateau.plateau().getJoueurCourant().piocher();
						} catch (HearthstoneException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						
						inter.interagir(choix, Plateau.plateau());
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println(Plateau.plateau().toString());

						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		} catch (HearthstoneException e) {
			
			e.printStackTrace();
		}
		
		try {
			for(ICarte i: Plateau.plateau().getJoueurCourant().getMain()) {
				System.out.println(i.toString());
			}
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static Interaction initialiserInteractions() {
		Interaction inter = null;
		/*monInterface = new Quitter(monInterface);*/
		inter = new UtiliserPouvoir(inter);
		inter = new UtiliserCarte(inter);
		inter = new JouerCarte(inter);
		inter = new FinirLeTour(inter);
		return inter;
	}
	
	
	private static String menu() {
		ArrayList<String>	menu = new ArrayList<String>();
		Interaction i = inter;
		while (i != null) {
			if (i.getDescription() != null)
				menu.add(i.getDescription());
			i = i.getSuivant();
		}
		
		int n = 1;
		for (String s : menu) {
			console.println(""+n+". "+s);
			n++;
		}
		
		console.println("");
		console.println("Votre choix : ");
		int choix = console.readInt();
		
		return menu.get(choix-1);
	}

	
}