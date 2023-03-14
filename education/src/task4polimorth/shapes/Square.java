package task4polimorth.shapes;

import task4polimorth.shapes.Calculateable;

public class Square implements Calculateable {

    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double calcArea() {
        return a * a;
    }
}
