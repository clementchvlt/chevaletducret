package Joueur;
import java.util.ArrayList;

import Application.HearthstoneException;
import Carte.ICarte;
import Heros.Heros;


public class Joueur implements IJoueur{
	private String pseudo;
	private ArrayList<ICarte> deck;
	private ArrayList<ICarte> main;
	private Heros heros;
	private int mana;
	private int stockMana;
	private ArrayList<ICarte> jeu;
	
	public Joueur(String pseudo, ArrayList<ICarte> Deck, ArrayList<ICarte> Main,ArrayList<ICarte> Jeu, Heros heros, int mana, int stockMana) throws HearthstoneException {
		setPseudo(pseudo);
		setHeros(heros);
		setMana(mana);
		setStockMana(stockMana);
		this.main = Main;
		this.deck = Deck;
		this.jeu = Jeu;
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
		stockMana+=1;
		
	}

	@Override
	public void finirTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void piocher() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
}
