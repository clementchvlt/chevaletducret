package Plateau;

import Application.HearthstoneException;
import Joueur.IJoueur;

/**
 * Le plateau g�re toute la partie, notamment le d�but et la fin de partie. Il sait qui est le joueur
 * courant, qui est l'adversaire d'un joueur, etc. Il n'y a qu'un seul plateau en tout et pour tout. 
 * Je vous conseille de faire quelques recherche sur le design pattern 'Singleton'... 
 */
public interface IPlateau {
        /**
         * Ajoute un joueur � la partie. 
         * @param joueur Le joueur � ajouter
         * @throws HearthstoneException si l'on essaie d'ajouter un 3e joueur par exemple, si le joueur est null, etc...
         */
        void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Renvoie le joueur courant, c'est-�-dire celui qui a le tour et qui doit jouer
         * @return le joueur courant, ou null si la partie n'est pas d�mar�e
         */
        IJoueur getJoueurCourant();
        
        /**
         * Le setter qui va avec le getter
         * @param joueur Le nouveau joueur courant
         * @throws HearthstoneException si le nouveau joueur est null, etc. (faut tout tester naturellement...)
         */
        void setJoueurCourant(IJoueur joueur) throws HearthstoneException;
        
        
        void setAdversaire(IJoueur adversaire);
        
        
        
        /**
         * Renvoie....l'adversaire
         * @param joueur dont on veut l'adversaire
         * @return le joueur adverse
         * @throws HearthstoneException si le param est null ou si le param ne correspond � aucun des 2 joueurs de la partie, etc.
         */
        IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException;

        /**
         * Ca d�marre la partie. Il faut d�terminer al�atoirement le joueur qui commence, etc.
         * @throws HearthstoneException si 2 joueurs ne sont pas ajout�s, etc....
         */
        void demarrerPartie() throws HearthstoneException;
        
        /**
         * � votre avis ?
         * @return vrai si la partie a d�mar�e, faux sinon
         */
        boolean estDemarree();
        
        /**
         * Le joueur pass� en param�tre vient de d�cider de finir son tour. Du coup, le plateau
         * doit g�rer le changement de joueur courant (entre autres)
         * @param joueur le joueur qui a fini son tour et qui passe la main
         * @throws HearthstoneException si le joueur qui passe son tour, n'avait pas le tour, alors
         * c'est qu'il fait n'importe quoi !
         */
        void finTour(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Le h�ros du joueur adverse du joueur pass� en param�tre est mort. Donc le joueur � gagn� !
         * @param joueur celui qui a gagn�
         * @throws HearthstoneException au cas on souhaite...tricher !
         */
        void gagnePartie(IJoueur joueur) throws HearthstoneException;
}