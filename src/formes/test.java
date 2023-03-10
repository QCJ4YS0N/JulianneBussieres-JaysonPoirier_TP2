package formes;

import exceptions.FormeException;

public class test {
    public static void main(String[] args) throws FormeException {
        Object o = new Triangle(1, 1, 1);
        Object o2 = o;

        System.out.println(o2.toString());
    }
}