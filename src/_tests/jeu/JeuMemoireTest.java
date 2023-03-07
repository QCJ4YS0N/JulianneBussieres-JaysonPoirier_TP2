/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package jeu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuMemoireTest {
    static JeuMemoire jeu;

    @BeforeAll
    static void init() {
        jeu = new JeuMemoire();
    }

    @Test
    void getGrille() {
        assertEquals(JeuMemoire.COLONNE, jeu.getGrille().length);
        assertNotEquals(0, jeu.getGrille().length);
    }

    @Test
    void getNiveau() {

    }

    @Test
    void getNomForme() {
    }

    @Test
    void getVecteur() {
    }

    @Test
    void jouerHumain() {
    }

    @Test
    void jouerOrdi() {
    }
}