package utile;

import java.util.Random;

public class Utile {
    public static int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit etre plus grand que min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
