/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;

/**
 * Permet de créer une forme de type Rectangle
 */
public class Rectangle extends Forme {
    private int hauteur;
    private int largeur;

    public Rectangle(int hauteur, int largeur) throws FormeException {
        super("Rectangle");
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    @Override
    public int calculerPerimetre() {
        return 2 * hauteur + 2 * largeur;
    }

    @Override
    public int calculerSurface() {
        return hauteur * largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public static boolean hauteurEstValide(int hauteur) {
        return MIN_VAL <= hauteur && hauteur <= MAX_VAL;
    }

    public static boolean largeurEstValide(int largeur) {
        return MIN_VAL <= largeur && largeur <= MAX_VAL;
    }

    public void setHauteur(int hauteur) throws FormeException {
        if (hauteurEstValide(hauteur)) {
            this.hauteur = hauteur;
        } else {
            throw new FormeException();
        }
    }

    public void setLargeur(int largeur) throws FormeException {
        if (largeurEstValide(largeur)) {
            this.largeur = largeur;
        } else {
            throw new FormeException();
        }
    }

    @Override
    public String toString() {
        return super.toString() + hauteur + " " + largeur;
    }
}
