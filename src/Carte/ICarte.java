package Carte;

import Application.HearthstoneException;
import Joueur.IJoueur;

/**
 * Une carte, ben c'est une carte du jeu quoi ! Une carte peut �tre
 * une carte de sort ou une carte serviteur (on ne s'occupe pas des autres sortes de cartes).
 * @see IJoueur
 */
public interface ICarte extends Cloneable {
       
       String getNom();                // Une carte doit avoir un nom
       int getCout();                  // Une carte co�te un crtain nombre de mana
       IJoueur getProprietaire();      // Une carte appartient � un joueur
        
        /**
         * Une carte peut avoir un effet au d�but de chaque tour o� elle est en jeu
         * @param cible ce parametre peut �tre null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut �tre �gale � n'importe quoi d'autre qui arrange la carte (un h�ros, un serviteur, une autre carte...) 
         * @throws HearthstoneException
         */
        void executerEffetDebutTour(Object cible) throws HearthstoneException;

        /**
         * Une carte peut avoir un effet � la fin d'un chaque tour o� elle est en jeu
         * @param cible ce parametre peut �tre null si la carte n'a pas besoin d'une cible pour l'effet en question.
         * La cible peut �tre �gale � n'importe quoi d'autre qui arrange la carte (un h�ros, un serviteur, une autre carte...) 
         * @throws HearthstoneException
         */
        void executerEffetFinTour(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir un effet au d�but de sa mise en jeu 
         * @param cible ce parametre peut �tre null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut �tre �gale � n'importe quoi d'autre qui arrange la carte (un h�ros, un serviteur, une autre carte...)   * @throws HearthstoneException
         */
        void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir un effet au moment de sa disparition du jeu 
         * @param cible ce parametre peut �tre null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut �tre �gale � n'importe quoi d'autre qui arrange la carte (un h�ros, un serviteur, une autre carte...)   * @throws HearthstoneException
         * @throws HearthstoneException
         */
        void executerEffetDisparition(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir une action qui se commande � n'importe quel moment du tour lorsqu'elle est en jeu 
         * @param cible ce parametre peut �tre null si la carte n'a pas besoin d'une cible pour l'action en question. 
         * La cible peut �tre �gale � n'importe quoi d'autre qui arrange la carte (un h�ros, un serviteur, une autre carte...)   * @throws HearthstoneException
         * @throws HearthstoneException
         */
        void executerAction(Object cible) throws HearthstoneException;
        
        /**
         * Fonction qui teste si les conditions pour que la carte soit encore pr�sente au tour suivant. Si la fonction
         * renvoie vrai, il faut s�rement la retirer du board...
         * @return true si la carte est foutu (un serviteur tu�, un sort lanc�, etc.)
         */
        boolean disparait();
}
