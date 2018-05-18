package Joueur;

import java.util.ArrayList;

import Application.HearthstoneException;
import Carte.ICarte;
import Heros.Heros;

/**
 * Cette interface d�finit le comportement (normalement) minimal d'un joueur
 *
 */
public interface IJoueur {
        /**
         * Nombre max de mana que le joueur peut avoir (10 en principe)
         */
        public final static int MAX_MANA = 10;          // Nombre max de mana
        
        /**
         * Le nombre max de cartes qui peuvent composer un deck. 
         */
        public final static int TAILLE_DECK = 15;       // Nombre max de cartes dans le deck

        /**
         * @return C'est le h�ros choisi par le joueur
         */
        Heros getHeros();
        
        /**
        * @return C'est le pseudo du joueur
         */
       String getPseudo();

        /**
         * Le nombre de mana augmente de 1 � chaque tour. Mais il ne pourra pas d�passer la constante MAX_MANA.
         * Certaines cartes peuvent augmenter ce nombre en cours de jeu (comme la carte Croissance sauvage)
         * @return nombre de manas potentiels du joueur au d�but du tour
         */
        int getMana();
        
        /**
         * Nombre de manas encore disponibles pendant le tour. Le stock est rempli � chaque d�but de tour avec les mans potentiels.
         * @return nombre de mana encore en stock
         * @see getMana() 
         */
        int getStockMana();
        
        /**
         * La main est l'ensemble des cartes pioch�es par le joueur mais non encore mises en jeu.
         * @return La liste des cartes de la main
         */
        ArrayList<ICarte> getMain();
        
        /**
         * Le jeu d'un joueur est compos� des cartes plac�es sur le board
         * @return La liste des cartes en jeu
         */
        ArrayList<ICarte> getJeu();
        
        /**
         * Permet de rechercher une carte en jeu par rapport � un bout de son nom (gr�ce � la fonction contains de la classe String).
         * @param nomCarte C'est une chaine de caract�res qui correspond au nom ou � un bout du nom de la carte que l'on souhaite
         * @return la premi�re carte trouv�e ou null si aucune carte ne correspond
         */
        ICarte getCarteEnJeu(String nomCarte);  
        
        
        /**
         * Permet de rechercher une carte de la main par rapport � un bout de son nom (gr�ce � la fonction contains de la classe String).
         * @param nomCarte C'est une chaine de caract�res qui correspond au nom ou � un bout du nom de la carte que l'on souhaite
         * @return la premi�re carte trouv�e ou null si aucune carte ne correspond
         */
        ICarte getCarteEnMain(String nomCarteMain);

        
        
        /**
         * Il se passe beaucoup de choses au moment o� le joueur prend le tour. Son nombre de mana augmente,
         * son stock est r�initialis� en cons�quence, les erviteurs en attente deviennent jouables, etc.
         * @throws HearthstoneException Si jamais le joueur tente de prendre le tour alors que ce n'est pas � lui de le faire...
         */
        void prendreTour() throws HearthstoneException;

        /**
         * Il se passe beaucoup de choses au moment o� le joueur finit le tour. 
         * @throws HearthstoneException Si jamais le joueur tente de finir le tour alors que ce n'est pas � lui de le faire...
         */
        void finirTour() throws HearthstoneException;
        
        /**
         * Au d�but de chaque tour, une carte du deck est choisie al�atoirement et est plac�e dans la main du joueur. 
         * Elle est naturellement enlev�e de son deck.
         * @throws HearthstoneException En cas de probl�me, une exception...
         */
        void piocher() throws HearthstoneException;
        
        /**
         * Pendant le tour, un joueur peut tenter de prendre une carte de sa main et de la placer sur le board. 
         * Si c'est possible, elle est retir�e de la main et plac�e sur le board. Evidemment, il faut faire
         * attention aux effets de mise en jeu �ventuels, aux contr�les, etc.
         * @param carte La carte jou�e
         * @throws HearthstoneException En cas de probl�me, une exception...
         * @see ICarte
         */
        void jouerCarte(ICarte carte) throws HearthstoneException;
        
        /**
         * Pendant le tour, un joueur peut tenter de prendre une carte de sa main et de la placer sur le board. 
         * Si c'est possible, elle est retir�e de la main et plac�e sur le board. Evidemment, il faut faire
         * attention aux effets de mise en jeu �ventuels, aux contr�les, etc. C'est la m�me chose que la fonction
         * jouerCarte(carte), mais ici il faut pr�ciser la cible obligatoirement
         * @param carte La carte...
         * @param cible Sa cible...
         * @throws HearthstoneException En cas de probl�me, une exception...
         */
        void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
        
        /**
         * Lorsque qu'une carte est en jeu, le joueur peut utiliser cette carte. Utiliser un serviteur
         * consistera � attaque la cible (un autre serviteur ou le h�ros), � utiliser un sort, etc. 
         * @param carte La carte
         * @param cible La cible
         * @throws HearthstoneException En cas de probl�me, une exception...
         */
        void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
        
        /**
         * Cette fonction utilise le pouvoir du h�ros du joueur pour faire quelque chose sur la cible...
         * @param cible La cible...
         * @throws HearthstoneException En cas de probl�me, une exception...
         */
        void utiliserPouvoir(Object cible) throws HearthstoneException;
        
        /**
         * Lorsqu'une carte a fini sa vie (un serviteur qui meut, un sort qui vient d'�tre utilis�, ...), il 
         * faut g�rer le jeu (une carte en moins...), ainsi que les effets li�s � la disparition de la carte (Rale d'agonie par exemple).
         * @param carte La carte qui est perdue
         * @throws HearthstoneException En cas de probl�me, une exception...
         */
        void perdreCarte(ICarte carte) throws HearthstoneException;
        
        
        
}
