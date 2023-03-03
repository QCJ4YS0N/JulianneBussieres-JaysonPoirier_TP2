/*
420-202 – TP2 – Traitement de données orienté objet
 Lien GIT Hub : https://github.com/robertAube/TP2/commits/main
 Nom : Bussières, Julianne; 2236326
 Nom : Poirier, Jayson; 2243405
*/
package formes;

import exceptions.FormeException;

import java.util.Arrays;

/**
 * Permet de créer une forme de type Triangle
 */
public class Triangle extends Forme {
    /**
     * Le coté A d'un triangle
     */
    private int coteA;
    /**
     * Le coté B d'un triangle
     */
    private int coteB;
    /**
     * Le coté C d'un triangle
     */
    private int coteC;

    /**
     * Le constructeur de la classe Triangle
     *
     * @param coteA Le coté A d'un triangle
     * @param coteB Le coté B d'un triangle
     * @param coteC Le coté C d'un triangle
     * @throws FormeException Peut lancer une exception dans le cas d'un coté invalide ou que les valeurs de cotés ne peuvent créer de triangle
     */
    public Triangle(int coteA, int coteB, int coteC) throws FormeException {
        super("Triangle");

        if (coteEstValide(coteA) && coteEstValide(coteB) && coteEstValide(coteC)) {
            this.coteA = coteA;
            this.coteB = coteB;
            this.coteC = coteC;
        }
        estTriangle(coteA, coteB, coteC);
    }

    /**
     * Calcule le périmètre d'une forme
     *
     * @return Le périmètre d'une forme
     */
    @Override
    public int calculerPerimetre() {
        return coteA + coteB + coteC;
    }

    /**
     * Calcule la surface d'une forme
     *
     * @return La surface d'une forme
     */
    @Override
    public int calculerSurface() {
        double p = calculerPerimetre() / 2.0;

        return (int) (Math.sqrt((p * ((p - coteA) * (p - coteB) * (p - coteC)))));
    }

    /**
     * Vérifie si un coté donné en argument est valide selon les valeurs minimales et maximales des formes
     *
     * @param cote Le coté à valider
     * @return true si le coté est plus grand que la valeur minimale et plus petite que la valeur maximale
     * @throws FormeException Lance une exception si le coté est invalide
     */
    public static boolean coteEstValide(int cote) throws FormeException {
        if (MIN_VAL <= cote && cote <= MAX_VAL) {
            return true;
        }
        throw new FormeException("Le cote : " + cote + "est invalide");
    }

    /**
     * Vérifie si le triangle est de type rectangle grâce à la formule de pythagore
     *
     * @return true si le triangle est de type rectangle
     */
    public boolean estRectangle() {
        int[] cotes = getCotesTries(coteA, coteB, coteC);

        return cotes[2] == Math.sqrt((Math.pow(cotes[0], 2) + Math.pow(cotes[1], 2)));
    }

    /**
     * Vérifie si les cotés en argument peuvent créer un triangle valide
     *
     * @param a Le coté A d'un triangle
     * @param b Le coté B d'un triangle
     * @param c Le coté C d'un triangle
     * @return true si la somme des deux plus petit coté est supérieure ou égale au plus grand coté
     * @throws FormeException Lance une exception si les cotés ne peuvent créer de triangle valide
     */
    public static boolean estTriangle(int a, int b, int c) throws FormeException {
        int[] cotes = getCotesTries(a, b, c);

        if (cotes[2] <= cotes[1] + cotes[0]) {
            return true;
        }
        throw new FormeException("La forme n'est pas un triangle valide");
    }

    /**
     * Retourne le coté A d'un triangle
     *
     * @return le coté A d'un triangle
     */
    public int getCoteA() {
        return coteA;
    }

    /**
     * Retourne le coté B d'un triangle
     *
     * @return le coté B d'un triangle
     */
    public int getCoteB() {
        return coteB;
    }

    /**
     * Retourne le coté C d'un triangle
     *
     * @return le coté C d'un triangle
     */
    public int getCoteC() {
        return coteC;
    }

    /**
     * Retourne les cotés triés du plus petit au plus grand du triangle
     *
     * @return un tableau contenant les cotés triés du plus petit au plus grand d'un triangle
     */
    private int[] getCotesTries() {
        int[] cotes = {coteA, coteB, coteC};

        Arrays.sort(cotes);
        return cotes;
    }

    /**
     * Retourne les cotés reçus en argument triés du plus petit au plus grand
     *
     * @return un tableau contenant les cotés reçus en argument triés du plus petit au plus grand
     */
    private static int[] getCotesTries(int coteA, int coteB, int coteC) {
        int[] cotes = {coteA, coteB, coteC};

        Arrays.sort(cotes);
        return cotes;
    }

    /**
     * Retourne le nombre de cotés égaux dans un triangle
     *
     * @return Le nombre de cotés égaux dans un triangle
     */
    private int getNbrCotesEgaux() {
        int[] cotes = getCotesTries();
        int nbCotesEgaux = 1;

        for (int i = 1; i < 3; i++) {
            if (cotes[i] == cotes[i - 1]) {
                nbCotesEgaux++;
            }
        }
        return nbCotesEgaux;
    }

    /**
     * Retourne le type du triangle
     *
     * @return RECTANGLE si le triangle est rectangle grâce à la méthode estRectangle
     * @return ISOCELE si le triangle à deux cotés de même grandeur
     * @return EQUILATERAL si le triangle à tous ses cotés de même grandeur
     * @return SCALENE si le triangle n'a pas de cotés de même grandeur et n'est pas rectangle
     */
    public TypeTriangle getType() {
        int nbCotesEgaux = getNbrCotesEgaux();

        if (estRectangle()) {
            return TypeTriangle.RECTANGLE;
        } else if (nbCotesEgaux == 2) {
            return TypeTriangle.ISOCELE;
        } else if (nbCotesEgaux == 3) {
            return TypeTriangle.EQUILATERAL;
        }
        return TypeTriangle.SCALENE;
    }

    /**
     * Ajoute le type de triangle ainsi que la valeur de chaque coté à la ligne de texte du toString de Forme
     *
     * @return La ligne de texte créé par le toString de Forme à laquelle on ajoute le type dy trianle et les valeurs du coté A, B et C
     */
    @Override
    public String toString() {
        return super.toString() + getType() + " " + coteA + " " + coteB + " " + coteC;
    }
}
