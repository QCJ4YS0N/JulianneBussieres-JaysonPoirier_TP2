/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package _tests.formes;

import exceptions.FormeException;
import formes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FormeTest {
    static Triangle t1;
    static Triangle t2;
    static Triangle t3;
    static Triangle t4;
    static Triangle t5;
    static Triangle t6;
    static Triangle t7;

    static Cercle c1;

    static Rectangle r1;

    @BeforeAll
    static void init() {
        try {
            t1 = new Triangle(4, 3, 5);
            t2 = new Triangle(3, 2, 4);
            t3 = new Triangle(3, 6, 6);
            t4 = new Triangle(5, 5, 5);
            t5 = new Triangle(4, 8, 7);
            t6 = new Triangle(3, 5, 4);
            t7 = new Triangle(5, 4, 3);
            c1 = new Cercle(5);
            r1 = new Rectangle(3, 5);
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void setCouleur() {
        t1.setCouleur(Couleur.NOIR);
        assertEquals(Couleur.NOIR, t1.getCouleur());

        t1.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, t1.getCouleur());

        t1.setCouleur(null);
        assertEquals(Couleur.BLEU, t1.getCouleur());
    }

    @Test
    void getNom() {
        assertEquals("Triangle", t1.getNom());
        assertEquals("Cercle", c1.getNom());
        assertEquals("Rectangle", r1.getNom());
    }

    @Test
    void equals() {
        assertEquals(t1, t1);
        assertNotEquals(t1, t2);
        assertEquals(t6, t7);
        t1.setCouleur(Couleur.BLEU);
        assertNotEquals(t1, t7);
    }

    @Test
    void compareTo() {
        Triangle[] triangleTab = {t1, t2, t3, t4, t5, t6};
        Triangle[] sortedTriangleTab = {t1, t5, t4, t3, t6, t2};
        Forme[] formeTab = {t1, c1, r1};
        Forme[] sortedFormeTab = {c1, r1, t1};

        t1.setCouleur(Couleur.BLEU);
        t2.setCouleur(Couleur.VERT);
        t3.setCouleur(Couleur.ORANGE);
        t4.setCouleur(Couleur.NOIR);
        t5.setCouleur(Couleur.JAUNE);
        Arrays.sort(triangleTab);
        for (int i = 0; i < 6; i++) {
            assertEquals(sortedTriangleTab[i], triangleTab[i]);
        }

        Arrays.sort(formeTab);
        for (int i = 0; i < 3; i++) {
            assertEquals(sortedFormeTab[i], formeTab[i]);
        }
    }
}