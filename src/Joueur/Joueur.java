package Joueur;
import java.util.ArrayList;

import Application.HearthstoneException;
import Capacites.Provocation;
import Carte.Carte;
import Carte.ICarte;
import Carte.Serviteur;
import Carte.Sorts;
import Heros.Heros;
import Plateau.IPlateau;
import Plateau.Plateau;


/**
	*Classe Joueur, dans chaque partie il y a deux joueurs. Chaque joueur a un heros; une main, un deck et un jeu qui 	*sont composes dune liste de cartes
	*@author Corentin/Clement
	*/

public class Joueur implements IJoueur{
	private String pseudo;
	private ArrayList<ICarte> deck;
	private ArrayList<ICarte> main;
	private Heros heros;
	private int mana;
	private int stockMana;
	private ArrayList<ICarte> jeu;
	private IPlateau plateau;
	
	public Joueur(String pseudo, ArrayList<ICarte> Deck, ArrayList<ICarte> Main,ArrayList<ICarte> Jeu, Heros heros, int mana, int stockMana) {
		setPseudo(pseudo);
		setHeros(heros);
		setMana(mana);
		setStockMana(stockMana);
		this.main = Main;
		this.deck = Deck;
		this.jeu = Jeu;
	}
	
	/**
	* fonction qui renvoie true si le joueur possède une carte avec la capacite provocation dans son jeu
	*@author Corentin/Clement
	*/
	public boolean aProvoc() {
		try {
			for (ICarte c : Plateau.plateau().getAdversaire(Plateau.plateau().getJoueurCourant()).getJeu()) {
				if(c.getCapacite()instanceof Provocation) {
					return true;
				}
			}
		} catch (HearthstoneException e) {
			e.printStackTrace();
		}return false;
	}

	public void setMana(int mana) {
		this.mana=mana;
	}
	
	public void setStockMana(int stockMana) {
		this.stockMana=stockMana;
	}
	
	private void setHeros(Heros heros) {
		this.heros=heros;
		
	}

	private void setPseudo(String pseudo) {
		this.pseudo=pseudo;
		
	}

	@Override
	public Heros getHeros() {
		return this.heros;
	}

	@Override
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	* @return nombre de mana disponibles au debut du tour
	*@author Corentin/Clement
	*/
	public int getMana() {
		return this.mana;
	}
	
	/**
	* @return nombre de mana encore disponibles
	*@author Corentin/Clement
	*/
	public int getStockMana() {
		
		return this.stockMana;
	}

	/**
	* @return la liste des cartes de la main
	*@author Corentin/Clement
	*/
	public ArrayList<ICarte> getMain() {
		return this.main;
	}

	/**
	* @return les cartes dans jeu
	*@author Corentin/Clement
	*/
	public ArrayList<ICarte> getJeu() {
		return this.jeu;
	}


	/**
	*@param morceau du nom de la carte recherchee
	* @return une carte de jeu
	*@author Corentin/Clement
	*/
	public ICarte getCarteEnJeu(String nomCarte) {
		for(ICarte i : jeu) {
			if(i.getNom().contains(nomCarte)){
				return i;
			}
		}
		return null;
	}

	/**
	*@param morceau du nom de la carte recherchee
	* @return une carte de main
	*@author Corentin/Clement
	*/
	public ICarte getCarteEnMain(String nomCarte) {
		for(ICarte i : main) {
			if(i.getNom().contains(nomCarte)){
				return i;
			}
		}
		return null;
	}

	/**
	*nb mana augmente, stock de mana  reinitialise, serviteurs en attente deviennent jouables
	*@throws HearthstoneException si joueur essaie de finir le tour mais pas a lui
	*@author Corentin/Clement
	*/

	public void prendreTour() throws HearthstoneException {
		mana+=1;
		stockMana=mana;
		try{
			this.piocher();
		}catch(HearthstoneException e) {
			e.printStackTrace();
		}
		for(ICarte i : jeu ) {
			if(i.getPeutAttaquer() == false) {
				i.setPeutAttaquer(true);
			}
		}
		heros.setPouvoirUtilisable(true);
		
	}

	/**
	*@les effets de fin de tour s’appliquent
	* @throws HearstoneException si joueur qui n’a pas la main essaie de jouer
	*@author Corentin/Clement
	*/
	public void finirTour() throws HearthstoneException {
		if(plateau.getJoueurCourant().getPseudo()==pseudo) {
			for(ICarte i : this.jeu) {
				try {
					i.getCapacite().executerEffetFinTour();
				}catch(HearthstoneException e) {
					e.printStackTrace();
				}
			}
		}throw new HearthstoneException("Ce n'est pas a toi de jouer");
		
	}

	/**
	*ajoute une carte venant de deck dans main et la supprime de deck
	* @throws HearthstoneException si le deck est vide
	*@author Corentin/Clement
	*/
	public void piocher() throws HearthstoneException {
		if(Plateau.plateau().getJoueurCourant().getDeck().isEmpty()==false) {
			Plateau.plateau().getJoueurCourant().getMain().add(Plateau.plateau().getJoueurCourant().getDeck().get(1));
			Plateau.plateau().getJoueurCourant().getDeck().remove(1);
		}else throw new HearthstoneException("Le deck est vide");

	}

	/**
	*ajoute une carte venant de main vers le jeu et la supprime donc de main
	*fait diminuer le nombre de mana utilisables en consequence
	* @throws HearthstoneException si la main est vide
	*@author Corentin/Clement
	*/
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if(main.isEmpty()==false) {
			if(carte.getCout()<=this.getStockMana()) {
				/*jeu.add(carte);
				main.remove(this.getCarteEnMain(carte.getNom()));*/
				jeu.add(carte);
				main.remove((Carte)carte);
				
				stockMana=stockMana-carte.getCout();
				carte.getCapacite().executerEffetMiseEnJeu(null);
			}else throw new HearthstoneException("Stock de mana insuffisant");
		}throw new HearthstoneException("Votre main est vide");
		
	}

	/**
	*Attaquer une carte ou le héros du joueur adverse
	*@param carte carte qu’on veut jouer
	* @param cible carte ou héros qu’on veut attaquer
	*@param throws HearthstoneException si pas assez de mana pour utiliser la carte
	*@author Corentin/Clement
	*/
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(carte.getCout()<=Plateau.plateau().getJoueurCourant().getStockMana()) {
			if(carte instanceof Serviteur) {
				jeu.add(carte);
				main.remove(carte);
				this.stockMana= stockMana - carte.getCout();
				try {
					carte.executerEffetDebutMiseEnJeu(carte);
				}catch(HearthstoneException e) {
					e.printStackTrace();
				}
			}else if(carte instanceof Sorts) {
				try {
					carte.executerEffetDebutMiseEnJeu(carte);
					this.stockMana=stockMana - carte.getCout();
					main.remove(carte);
				}catch (HearthstoneException e) {
					e.printStackTrace();
				}
			}
		}else throw new HearthstoneException("Pas assez de mana");
		
		
	}

	/**
	*attaquer une cible, utiliser un sort…
	*@param carte Carte a utiliser (si carte est un serviteur alors il attaque, si c’est un sort on effectue l’effet qu’il 		*possede)
	*@param cible Cible qu’on souhaite toucher (ca peut etre un ennemi a attaquer tout comme une carte du joueur ou 	*son hors qui reçoit des pv par ex)
	*@author Corentin/Clement
	*/
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(jeu.contains(carte)) {
			carte.executerAction(carte);
		}
		
	}

	/**
	*attaque avec pouvoir du heros
	*@param cible la cible de l’attaque, peut être importe quelle carte
	* @throws HearthstoneException si pas de pouvoir
	*@author Corentin/Clement
	*/
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		if(heros.getPouvoir()!=null) {
			heros.getPouvoir().executerEffetMiseEnJeu(cible);
		}else throw new HearthstoneException("Le pouvoir du heros est null");
		
	}

	/**
	*perdre carte permet de supprimer une carte du plateau (par ex quand elle meurt, ou que son effet est termine)
	*@param carte qu’on veut supprimer du plateau 
	*@throws HearthstoneException si la carte est absente du plateau
	*@authorCorentin/Clement
	*/
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		if(jeu.contains(carte)) {
			jeu.remove(carte);
		}else throw new HearthstoneException("La carte n'est pas sur le plateau");
			
	}

	/**
	*@return le deck du joueur souhaite
	*@authorCorentin/Clement
	*/
	public ArrayList<ICarte> getDeck() {
		return this.deck;
	}
	
}
