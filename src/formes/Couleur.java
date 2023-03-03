/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import java.util.Locale;

public enum Couleur {
    BLEU,
    JAUNE,
    NOIR,
    ORANGE,
    ROUGE,
    VERT,
    ROSE;

    public String getNom() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return getNom();
    }
}
