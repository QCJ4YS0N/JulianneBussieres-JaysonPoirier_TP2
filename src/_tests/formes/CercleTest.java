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

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {
    static Cercle c1;
    static Cercle c2;
    static Cercle c3;

    @BeforeAll
    static void init() {
        try {
            c1 = new Cercle(3);
            c2 = new Cercle(8);
            c3 = new Cercle(12);
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void calculerPerimetre() {
        assertEquals(18, c1.calculerPerimetre());
        assertEquals(50, c2.calculerPerimetre());
        assertEquals(75, c3.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        assertEquals(28, c1.calculerSurface());
        assertEquals(201, c2.calculerSurface());
        assertEquals(452, c3.calculerSurface());
    }
}