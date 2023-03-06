/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurFormesTest {

    static VecteurFormes vecteur;
    static Cercle c1;
    static Cercle c2;
    static Cercle c3;
    static Cercle c4;
    static Cercle c5;
    static Cercle c6;

    @BeforeAll
    static void init() throws FormeException {
        vecteur = new VecteurFormes();
        c1 = new Cercle(1);
        c1.setCouleur(Couleur.BLEU);
        c2 = new Cercle(1);
        c2.setCouleur(Couleur.NOIR);
        c3 = new Cercle(1);
        c3.setCouleur(Couleur.ORANGE);
        c4 = new Cercle(1);
        c4.setCouleur(Couleur.ROUGE);
        c5 = new Cercle(1);
        c5.setCouleur(Couleur.VERT);
        c6 = new Cercle(1);
        c6.setCouleur(Couleur.JAUNE);
    }

    @Test
    void getVecteur() {
        vecteur.getVecteur().add(c1);

        assertEquals(c1, vecteur.getVecteur().get(0));
    }

    @Test
    void remplir() {
        Forme[] bonVecteur = {c1, c2, c3, c4, c5, c6};

        try {
            vecteur.remplir(6);
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < bonVecteur.length; i++) {
            assertEquals(bonVecteur[i], vecteur.getVecteur().get(i));
        }
    }

    @Test
    void trier() {
        Forme[] bonVecteur = {c1, c6, c2, c3, c4, c5};

        remplir();
        vecteur.trier();

        for (int i = 0; i < bonVecteur.length; i++) {
            assertEquals(bonVecteur[i], vecteur.getVecteur().get(i));
        }
    }
}