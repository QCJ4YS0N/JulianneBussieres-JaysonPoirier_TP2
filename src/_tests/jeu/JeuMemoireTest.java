/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package jeu;

import exceptions.FormeException;
import formes.*;
import formes.VecteurFormes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JeuMemoireTest {
    static JeuMemoire jeu;

    @BeforeAll
    static void init() {
        jeu = new JeuMemoire();
    }

    @Test
    void getGrille_retourneGrilleDeBonneLongueur() {
        assertEquals(JeuMemoire.COLONNE, jeu.getGrille().length);
        assertNotEquals(0, jeu.getGrille().length);
    }

    @Test
    void getNiveau_retourneLeBonNiveau() {
        for (int i = 0; i < JeuMemoire.NIVEAU_MAX; i++) {
            assertEquals(i, jeu.getNiveau());
            jeu.setNiveauPlusUn();
        }
    }

    @Test
    void getNomForme_retourneLeBonNomForme() {
        VecteurFormes vecteurTest = jeu.getVecteur();
        Forme formeTest;
        String strTest;

        for (int i = 0; i < JeuMemoire.COLONNE; i++) {
            formeTest = vecteurTest.getVecteur().get(i);
            strTest = formeTest.getNom()+formeTest.getCouleur();

            assertEquals(strTest, jeu.getNomForme(0, i));
        }
    }

    @Test
    void getVecteur_retourneUnVecteurFormesDeBonneLongueur() throws FormeException {
        VecteurFormes vecteurTest = jeu.getVecteur();
        vecteurTest.remplir(JeuMemoire.NBR_ELEMENTS_GRILLE);

        assertEquals(JeuMemoire.NBR_ELEMENTS_GRILLE, vecteurTest.getVecteur().size());
        assertNotEquals(JeuMemoire.COLONNE, vecteurTest.getVecteur().size());
    }

    @Test
    void jouerHumain_retourneVraiSiDevineLeBonPoint() {
    }

    @Test
    void jouerOrdi_retourneDesPointsUniques() {
    }
}