package coffeeorder;

import java.util.Objects;

public class Order {

    private static int counter;
    private final int orderNumber;
    private final String name;

    public Order(String name) {
        counter++;
        this.orderNumber = counter;
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, name);
    }

    @Override
    public String toString() {
        return orderNumber + "\t| " + name;

    }

}



