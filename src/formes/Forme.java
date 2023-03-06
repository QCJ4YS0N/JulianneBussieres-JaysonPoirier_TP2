/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/QCJ4YS0N/JulianneBussieres-JaysonPoirier_TP2
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

public abstract class Forme implements Comparable<Forme> {
    /**
     * La couleur par défaut pour toute les formes est le rouge
     */
    public static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;
    /**
     * La valeur maximale des cotés ou rayon d'une forme est 30
     */
    public static final int MAX_VAL = 30;
    /**
     * La valeur minimale des cotés ou rayon d'une forme est 1
     */
    public static final int MIN_VAL = 1;

    /**
     * La couleur de la forme
     */
    private Couleur couleur;
    /**
     * Le nom de la forme
     */
    private String nom;

    /**
     * Constructeur de la classe
     *
     * @param nom Permet de donner un nom aux formes
     */
    public Forme(String nom) {
        setCouleur(COULEUR_DEFAUT);
        this.nom = nom;
    }

    /**
     * Calcule le périmètre d'une forme
     *
     * @return Le périmètre d'une forme
     */
    public abstract int calculerPerimetre();

    /**
     * Calcule la surface d'une forme
     *
     * @return La surface d'une forme
     */
    public abstract int calculerSurface();

    /**
     * Permet de comparer une forme selon le nom ou la couleur si le nom est pareil
     *
     * @param o the object to be compared.
     * @return -1 si la couleur de la forme courante est alphabétiquement avant, 0 si ils sont pareil et 1 si elle est alphabétiquement après
     * @return -1 si le nom de la forme courante est alphabétiquement avant, 0 si ils sont pareil et 1 si il est alphabétiquement après
     */
    @Override
    public int compareTo(Forme o) {
        if (nom.equals(o.nom)) {
            return couleur.compareTo(o.couleur);
        }
        return nom.compareTo(o.nom);
    }

    /**
     * Vérifie si la forme est égale avec un autre objet
     *
     * @param o L'objet avec lequel vérifier l'égalité
     * @return true si la couleur, le nom et la surface de deux formes sont pareil
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forme forme = (Forme) o;

        if (nom != null ? !nom.equals(forme.nom) : forme.nom != null) return false;

        return couleur == forme.couleur && calculerSurface() == forme.calculerSurface();
    }

    /**
     * Retourne la couleur d'une forme
     *
     * @return la couleur de la forme
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Retourne le nom d'une forme
     *
     * @return le nom de la forme
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet d'affecter une couleur à la forme
     *
     * @param couleur la couleur à affecter à la forme
     */
    public void setCouleur(Couleur couleur) {
        if (couleur != null) {
            this.couleur = couleur;
        }
    }

    public String toStringCourt() {
        return nom + " " + couleur;
    }

    /**
     * Crée une ligne de texte avec le nom et la couleur de la forme
     *
     * @return le nom et la couleur de la forme en texte
     */
    @Override
    public String toString() {
        return nom + " " + couleur + " ";
    }


}
