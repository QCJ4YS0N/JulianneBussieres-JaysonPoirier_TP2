/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package jeu;

import exceptions.FormeException;
import formes.*;
//test
import java.awt.*;
import java.util.ArrayList;

public class JeuMemoire implements IJeuMemoire {
//testy
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
        //todo retourne un Point dont les coordonnées (colonne et ligne) sont prises au hasard dans les limites de la grille de jeu
    }

    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    @Override
    public int getNiveau() {
        return niveau;
    }

    @Override
    public String getNomForme(int ligne, int colonne) {
        return grilleDeJeu[colonne][ligne].getNom() + grilleDeJeu[colonne][ligne].getCouleur();
    }

    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    @Override
    public boolean jouerHumain(int ligne, int colonne) {

    }

    @Override
    public ArrayList<Point> jouerOrdi() {
        for (int i = 0; i < (niveau + 2); i++) {
            //todo trouver la méthode java pour point unique
            vecteurPoints.add(choisirForme());
        }
        return vecteurPoints;
    }

    private void preparerGrilleDeJeu() {
        int k = 0;

        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                grilleDeJeu[j][i] = vecteurFormes.getVecteur().get(k++);
            }
        }
    }

    private void preparerVecteurFormes() throws FormeException {
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

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


    public static void main(String[] args) {

    }
}
