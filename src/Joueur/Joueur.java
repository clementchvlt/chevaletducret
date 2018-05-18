package Joueur;
import java.util.ArrayList;

import Carte.ICarte;


public class Joueur implements IJoueur{
	private String pseudo;
	private ArrayList<ICarte> deck;
	private ArrayList<ICarte> main;
	private Heros heros;
	private int mana;
	
	public Joueur(String pseudo, ArrayList<ICarte> Deck, ArrayList<ICarte> Main, Heros heros, int mana) throws HearthstoneException {
		setPseudo(pseudo);
		setHeros(heros);
		setMana(mana);
	}

	private void setMana(int mana) throws HearthstoneException {
		if(mana>MAX_MANA) throw new HearthstoneException("Le mana doit etre inferieur ou egal a 10"); 
		else this.mana=mana;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ICarte> getMain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ICarte> getJeu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICarte getCarteEnJeu(String nomCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICarte getCarteEnMain(String nomCarteMain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prendreTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
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
