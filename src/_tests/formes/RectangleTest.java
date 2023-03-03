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

class RectangleTest {
    static Rectangle r1;
    static Rectangle r2;
    static Rectangle r3;

    @BeforeAll
    static void init() {
        try {
            r1 = new Rectangle(4, 5);
            r2 = new Rectangle(9, 10);
            r3 = new Rectangle(3, 16);
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void calculerPerimetre() {
        assertEquals(18, r1.calculerPerimetre());
        assertEquals(38, r2.calculerPerimetre());
        assertEquals(38, r3.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        assertEquals(20, r1.calculerSurface());
        assertEquals(90, r2.calculerSurface());
        assertEquals(48, r3.calculerSurface());
    }
}