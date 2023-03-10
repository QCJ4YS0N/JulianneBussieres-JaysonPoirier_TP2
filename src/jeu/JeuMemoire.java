/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package jeu;

import exceptions.FormeException;
import formes.*;
import utile.Utile;

import java.awt.*;
import java.util.ArrayList;

public class JeuMemoire implements IJeuMemoire {

    public static final int COLONNE = 6;
    public static final int LIGNE = 6;
    private static final int LONGUEUR_CHAINE = 17;
    public static final int NBR_ELEMENTS_GRILLE = 36;

    private Forme[][] grilleDeJeu;
    private int niveau;
    private VecteurFormes vecteurFormes;
    private ArrayList<Point> vecteurPoints;

    public JeuMemoire() {
        try {
            preparerVecteurFormes();
            preparerGrilleDeJeu();
        } catch (FormeException e) {
            System.out.println("Une des formes de la matrice est invalide.");
        }
    }

    private String ajouterEspaces(int nbrChar, String str) {
        if (nbrChar < LONGUEUR_CHAINE) {
            for (int i = 0; i < (LONGUEUR_CHAINE - nbrChar); i++) {
                str += " ";
            }
        }
        return str;
    }

    private Point choisirForme() {
        return new Point(Utile.getNombreAleatoireEntreBorne(0, 5), Utile.getNombreAleatoireEntreBorne(0, 5));
    }

    /**
     * @return
     */
    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    /**
     * Connaître le niveau du jeu.
     *
     * @return le niveau du jeu
     */
    @Override
    public int getNiveau() {
        return niveau;
    }

    /**
     * Obtenir sous forme de chaîne sans espace le nom et la couleur de la forme
     * à l'emplacement désiré dans la grille.
     *
     * @param ligne   coordonnée ligne de la matrice grille
     * @param colonne coordonnée colonne de la matrice grille
     * @return nom et couleur concaténée en chaîne de caractère
     */
    @Override
    public String getNomForme(int ligne, int colonne) {
        return grilleDeJeu[colonne][ligne].getNom() + grilleDeJeu[colonne][ligne].getCouleur();
    }

    /**
     * Retourne le vecteurForme
     *
     * @return vecteurForme
     */
    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    /**
     * Valide si la coordonnée jouée par le joueur humain est valide et dans
     * l'ordre selon les coordonnées générées par l'ordinateur. Voir la méthode
     * "jouerOrdi()"
     *
     * @param ligne   coordonnée ligne de la grille
     * @param colonne coordonnée colonne dans la grille
     * @return oui ou non si la coordonnée du joueur est la coordonnée jouée par
     * l'ordi dans l'ordre respecté.
     */
    @Override
    public boolean jouerHumain(int ligne, int colonne) {
        Point pointADeviner = vecteurPoints.get(0);
        vecteurPoints.remove(0);

        if (pointADeviner.equals(new Point(colonne, ligne))) {
            return true;
        }

        return false;
    }

    /**
     * L'intelligence du jeu. Génère un tableau de coordonnées (des objets <b>Point(colonne, ligne)</b>)
     * au hasard. Les points générés doivent être valides dans la grille de jeu.
     * Le nombre de points générés est en relation avec le niveau courant du jeu.
     * Il obéit à la règle suivante:
     * <p>
     * Le nombre de points générés = niveau courant du jeu + 2
     *
     * <b>Il est important qu'un même point ne soit pas choisi 2 fois.</b>
     * <b>Note</b>: la classe java.awt.Point encapsule un x et un y. Alors que dans le JeuMemoire,
     * on utilise plutôt colonne et ligne. Ainsi, x correspond à colonne et y à ligne.
     *
     * @return la liste des coordonnées <b>Point(colonne, ligne)</b> des formes choisies dans la grille.
     */
    @Override
    public ArrayList<Point> jouerOrdi() {
        boolean unique = true;
        Point pointTemp;

        vecteurPoints = new ArrayList<>();
        for (int i = 0; i < (niveau + 2); i++) {
            pointTemp = choisirForme();
            for (int j = 0; j < vecteurPoints.size(); j++) {
                if (vecteurPoints.get(j) == pointTemp) {
                    unique = false;
                }
            }

            if (unique) {
                vecteurPoints.add(pointTemp);
            }
        }

        return vecteurPoints;
    }

    private void preparerGrilleDeJeu() {
        int k = 0;

        grilleDeJeu = new Forme[COLONNE][LIGNE];
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                grilleDeJeu[j][i] = vecteurFormes.getVecteur().get(k++);
            }
        }
    }

    private void preparerVecteurFormes() throws FormeException {
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

    /**
     * Ajoute 1 au niveau si celui-ci est en-dessous de 6, autrement il demeure à 6.
     */
    @Override
    public void setNiveauPlusUn() {
        if (niveau < NIVEAU_MAX) {
            niveau++;
        }
    }

    @Override
    public String toString() {
        String strTemp = "";
        String str = "";

        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                strTemp = grilleDeJeu[j][i].toStringCourt();
                str += ajouterEspaces(strTemp.length(), strTemp);
                str += "| ";
            }
            str += "\n";
        }

        return str;
    }
}
