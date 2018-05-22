package Capacites;

import Application.HearthstoneException;

/**
 * Une capacit�, c'est l'abstraction g�n�rique pour d�crire, le pouvoir du h�ros, le sort d'une carte Sort, la capacit� d'un serviteur, etc.
 */
public interface ICapacite {
        /**
         * Le nom de la capacit� ("Boule de feu")
         * @return Une chaine de caract�res...
         */
        String getNom();
        
        /**
         * La description de la capacit� ("Inflige +1 points de d�gat au h�ros vis�"
         * @return Une chaine de caract�res
         */
        String getDescription();

        /**
         * Certaines capacit� agissent en d�but de tour (J'ai pas d'exemple mais on ne sait jamais)
         * @throws HearthstoneException En cas de probl�me...
         */
        void executerEffetDebutTour() throws HearthstoneException;
        
        /**
         * Certaines capacit� agissent en fin de tour (J'ai pas d'exemple mais on ne sait jamais)
         * @throws HearthstoneException En cas de probl�me...
         */
        void executerEffetFinTour() throws HearthstoneException;
        
        /**
         * Certaines capacit� agissent quand on le demande, et �ventuellement sur une cible...
         * @throws HearthstoneException En cas de probl�me...
         */
        void executerAction(Object cible) throws HearthstoneException;

        /**
         * Certaines capacit� agissent en d�but de mise en jeu. C'est souvent le cas des sorts.
         * @throws HearthstoneException En cas de probl�me...
         */
        void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;
        
        /**
         * Certaines capacit� agissent lorsque la carte dispara�t du jeu (comme le r�le d'agonie...). 
         * @throws HearthstoneException En cas de probl�me...
         */
        void executerEffetDisparition(Object cible) throws HearthstoneException;
}


