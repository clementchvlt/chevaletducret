package Joueur;
import java.util.ArrayList;

import Application.HearthstoneException;
import Capacites.Provocation;
import Carte.ICarte;
import Carte.Serviteur;
import Carte.Sorts;
import Heros.Heros;
import Plateau.IPlateau;
import Plateau.Plateau;


public class Joueur implements IJoueur{
	private String pseudo;
	private ArrayList<ICarte> deck;
	private ArrayList<ICarte> main;
	private Heros heros;
	private int mana;
	private int stockMana;
	private ArrayList<ICarte> jeu;
	private IPlateau plateau;
	
	public Joueur(String pseudo, ArrayList<ICarte> Deck, ArrayList<ICarte> Main,ArrayList<ICarte> Jeu, Heros heros, int mana, int stockMana) throws HearthstoneException {
		setPseudo(pseudo);
		setHeros(heros);
		setMana(mana);
		setStockMana(stockMana);
		this.main = Main;
		this.deck = Deck;
		this.jeu = Jeu;
	}
	
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

	private void setMana(int mana) throws HearthstoneException {
		if(mana>MAX_MANA) throw new HearthstoneException("Le mana doit etre inferieur ou egal a 10"); 
		else this.mana=mana;
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

	@Override
	public int getMana() {
		return this.mana;
	}
	
	@Override
	public int getStockMana() {
		
		return this.stockMana;
	}

	@Override
	public ArrayList<ICarte> getMain() {
		return this.main;
	}

	@Override
	public ArrayList<ICarte> getJeu() {
		return this.jeu;
	}

	@Override
	public ICarte getCarteEnJeu(String nomCarte) {
		for(ICarte i : jeu) {
			if(i.getNom().contains(nomCarte)){
				return i;
			}
		}
		return null;
	}

	@Override
	public ICarte getCarteEnMain(String nomCarte) {
		for(ICarte i : main) {
			if(i.getNom().contains(nomCarte)){
				return i;
			}
		}
		return null;
	}

	@Override
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

	@Override
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

	@Override
	public void piocher() throws HearthstoneException {
		if(deck.isEmpty()==false) {
			main.add(deck.get(1));
			deck.remove(1);	
		}else throw new HearthstoneException("Le deck est vide");

	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if(main.isEmpty()==false) {
			if(carte.getCout()<=this.getStockMana()) {
				jeu.add(carte);
				main.remove(this.getCarteEnMain(carte.getNom()));
				stockMana=stockMana-carte.getCout();
				carte.getCapacite().executerEffetMiseEnJeu(null);
			}else throw new HearthstoneException("Stock de mana insuffisant");
		}throw new HearthstoneException("Votre main est vide");
		
	}

	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(carte.getCout()<=this.getStockMana()) {
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

	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if(jeu.contains(carte)) {
			carte.executerAction(carte);
		}
		
	}

	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		if(heros.getPouvoir()!=null) {
			heros.getPouvoir().executerEffetMiseEnJeu(cible);
		}else throw new HearthstoneException("Le pouvoir du heros est null");
		
	}

	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		if(jeu.contains(carte)) {
			jeu.remove(carte);
		}else throw new HearthstoneException("La carte n'est pas sur le plateau");
			
	}
	
}
