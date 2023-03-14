package task4polimorth.shapes;

import task4polimorth.shapes.Calculateable;

public class Circle implements Calculateable {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return 3.14 * (radius * radius);
    }
}
