/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;

import java.util.ArrayList;

public class VecteurFormes {

    private ArrayList<Forme> vecteur;


    public VecteurFormes() {
        vecteur = new ArrayList<>();
    }

    private void addForme(Forme forme, Couleur couleur) {
        forme.setCouleur(couleur);
        vecteur.add(forme);
    }

    public ArrayList<Forme> getVecteur() {
        return vecteur;
    }

    public void melanger() {

    }

    private void permuter(int a, int b) {

    }

    public void remplir(int nbrFormesVoulues) throws FormeException {
        while (vecteur.size() < nbrFormesVoulues) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    if (i == 0) {
                        vecteur.add(new Cercle(1));
                    } else if (i == 1) {
                        vecteur.add(new Rectangle(1, 1));
                    } else {
                        vecteur.add(new Triangle(1, 1, 1));
                    }
                    if (j == 0) {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.BLEU);
                    } else if (j == 1) {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.NOIR);
                    } else if (j == 2) {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.ORANGE);
                    } else if (j == 3) {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.ROUGE);
                    } else if (j == 4) {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.VERT);
                    } else {
                        vecteur.get(vecteur.size() - 1).setCouleur(Couleur.JAUNE);
                    }
                }
            }
        }
    }

    public void trier() {

    }

    private static boolean validerNbrFormes(int nbrForme) {

    }

    @Override
    public String toString() {

    }

}
}
