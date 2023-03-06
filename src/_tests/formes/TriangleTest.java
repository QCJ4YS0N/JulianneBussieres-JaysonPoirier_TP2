/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;
import org.junit.jupiter.api.*;
import static formes.Forme.*;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    static Triangle t1;
    static Triangle t2;
    static Triangle t3;
    static Triangle t4;
    static Triangle t5;
    static Triangle t6;
    static Triangle t7;

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
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void constructeur() {
        assertThrows(FormeException.class, () -> {
            Triangle t = new Triangle(-1, 2, 3);
        });
        assertThrows(FormeException.class, () -> {
            Triangle t = new Triangle(1, 2, 4);
        });
    }

    @Test
    void calculerPerimetre() {
        assertEquals(12, t1.calculerPerimetre());
        assertEquals(9, t2.calculerPerimetre());
        assertEquals(15, t3.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        assertEquals(6, t1.calculerSurface());
        assertEquals(2, t2.calculerSurface());
        assertEquals(8, t3.calculerSurface());
        assertEquals(10, t4.calculerSurface());
        assertEquals(13, t5.calculerSurface());
    }

    @Test
    void testCoteEstValide() {
        assertThrows(FormeException.class, () -> Triangle.coteEstValide(MAX_VAL + 1));
        assertThrows(FormeException.class, () -> Triangle.coteEstValide(MIN_VAL - 1));
        try {
            assertTrue(Triangle.coteEstValide(8));
            assertTrue(Triangle.coteEstValide(20));
        } catch (FormeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void estRectangle() {
        assertTrue(t1.estRectangle());
        assertTrue(t7.estRectangle());
        assertFalse(t2.estRectangle());
    }

    @Test
    void getCoteA() {
        assertEquals(4, t1.getCoteA());
    }

    @Test
    void getCoteB() {
        assertEquals(3, t1.getCoteB());
    }

    @Test
    void getCoteC() {
        assertEquals(5, t1.getCoteC());
    }

    @Test
    void getType() {
        assertEquals(TypeTriangle.EQUILATERAL, t4.getType());
        assertEquals(TypeTriangle.SCALENE, t2.getType());
        assertEquals(TypeTriangle.ISOCELE, t3.getType());
        assertEquals(TypeTriangle.RECTANGLE, t6.getType());
    }

    @Test
    void testToString() {
        t4.setCouleur(Couleur.ROUGE);
        assertEquals("Triangle rouge équilatéral 5 5 5", t4.toString());
    }
}