/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;
import utile.Utile;

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

    /**
     * Obtenir le vecteur de formes
     *
     * @return le vecteur de formes
     */
    public ArrayList<Forme> getVecteur() {
        return vecteur;
    }

    /**
     * Mélanger les éléments du vecteur.
     */
    public void melanger() {
        ArrayList<Forme> newTab = new ArrayList<>();
        ArrayList<Integer> randomIntTab = new ArrayList<>();
        int randomInt = Utile.getNombreAleatoireEntreBorne(0, (vecteur.size() - 1));

        while (randomIntTab.size() < vecteur.size()) {
            if (!randomIntTab.contains(randomInt)) {
                randomIntTab.add(randomInt);
            }
            randomInt = Utile.getNombreAleatoireEntreBorne(0, (vecteur.size() - 1));
        }

        for (int i = 0; i < vecteur.size(); i++) {
            newTab.add(vecteur.get(randomIntTab.get(i)));
        }

        vecteur = newTab;
    }

    private void permuter(int a, int b) {
        Forme f1 = vecteur.get(a);

        vecteur.set(a, vecteur.get(b));
        vecteur.set(b, f1);
    }

    /**
     * Mettre le nombre de formes voulues dans le vecteur. Les formes qui seront
     * placées dans le vecteur devront être générées de la façon suivante:
     * <p>
     * Tant que le nombre de formes souhaitées n'est pas atteint on crée une forme
     * à la fois, pour toutes les formes disponibles (Cercle, Rectangle et
     * Triangle) combiné à toutes les couleurs possibles (rouge, vert, bleu,
     * jaune, noir, orange). Quand toutes les combinaisons sont épuisées on
     * recommence.
     * <p>
     * Le but final étant d'obtenir le bon nombre de formes, les plus
     * diversifiées possibles.
     *
     * @param nbrElements le nombre de formes voulues
     */
    public void remplir(int nbrElements) throws FormeException {
        if (validerNbrFormes(nbrElements)) {
            while (vecteur.size() < nbrElements) {
                for (int i = 0; i < 3 && vecteur.size() < nbrElements; i++) {
                    for (int j = 0; j < 6 && vecteur.size() < nbrElements; j++) {
                        if (i == 0) {
                            if (j == 0) {
                                addForme(new Cercle(1), Couleur.BLEU);
                            } else if (j == 1) {
                                addForme(new Cercle(1), Couleur.NOIR);
                            } else if (j == 2) {
                                addForme(new Cercle(1), Couleur.ORANGE);
                            } else if (j == 3) {
                                addForme(new Cercle(1), Couleur.ROUGE);
                            } else if (j == 4) {
                                addForme(new Cercle(1), Couleur.VERT);
                            } else {
                                addForme(new Cercle(1), Couleur.JAUNE);
                            }
                        } else if (i == 1) {
                            if (j == 0) {
                                addForme(new Rectangle(1, 1), Couleur.BLEU);
                            } else if (j == 1) {
                                addForme(new Rectangle(1, 1), Couleur.NOIR);
                            } else if (j == 2) {
                                addForme(new Rectangle(1, 1), Couleur.ORANGE);
                            } else if (j == 3) {
                                addForme(new Rectangle(1, 1), Couleur.ROUGE);
                            } else if (j == 4) {
                                addForme(new Rectangle(1, 1), Couleur.VERT);
                            } else {
                                addForme(new Rectangle(1, 1), Couleur.JAUNE);
                            }
                        } else {
                            if (j == 0) {
                                addForme(new Triangle(1, 1, 1), Couleur.BLEU);
                            } else if (j == 1) {
                                addForme(new Triangle(1, 1, 1), Couleur.NOIR);
                            } else if (j == 2) {
                                addForme(new Triangle(1, 1, 1), Couleur.ORANGE);
                            } else if (j == 3) {
                                addForme(new Triangle(1, 1, 1), Couleur.ROUGE);
                            } else if (j == 4) {
                                addForme(new Triangle(1, 1, 1), Couleur.VERT);
                            } else {
                                addForme(new Triangle(1, 1, 1), Couleur.JAUNE);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < vecteur.size(); i++) {
            str += vecteur.get(i).getNom();
            str += vecteur.get(i).getCouleur();
            str += "\n";
        }
        return str;
    }

    /**
     * Trier en ordre croissant le vecteur de formes en utilisant le "compareTo"
     * disponible sur les objets.
     *
     * Méthode de tri: Sélection
     */
    public void trier() {
        int plusPetit;

        for (int i = 0; i < vecteur.size(); i++) {
            plusPetit = i;
            for (int j = i + 1; j < vecteur.size(); j++) {
                if (vecteur.get(plusPetit).compareTo(vecteur.get(j)) > 0) {
                    plusPetit = j;
                }
            }
            permuter(plusPetit, i);
        }
    }

    private static boolean validerNbrFormes(int nbrForme) {
        if (nbrForme > 0) {
            return true;
        }
        throw new IllegalArgumentException("Nombre de formes doit être supérieur à 0");
    }

}

