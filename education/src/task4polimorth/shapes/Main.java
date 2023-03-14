package task4polimorth.shapes;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(10);
        Square square = new Square(6);
        Triangle triangle = new Triangle(9, 4, 6);

        Calculateable[] shapes = {circle, square, triangle};
        System.out.println(Main.calcAreaSummary(shapes));

    }

    public static double calcAreaSummary(Calculateable[] shapes) {
        double result = 0;
        for (Calculateable shape : shapes) {
            result += shape.calcArea();
        }
        return result;
    }
}
