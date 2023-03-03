/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package gui;
/**
 * Application pour le jeu de mémoire
 *
 * @author Julie Freve & Robert Aubé
 */
public class AppMemoire {
    public static void main(String[] args) {
       // ControleurMemoire.bienvenu();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleurMemoire();
            }
        });
    }
}
