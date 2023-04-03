package coffeeorder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeeOrderBoard {

    private Queue<Order> orders = new LinkedList<>();

    public CoffeeOrderBoard(Queue<Order> orders) {
        this.orders = orders;
    }

    public void add(String name) {
        orders.add(new Order(name));
    }

    public Order deliver() {
        return orders.poll();
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("Num\t| Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orders=" + orders +
                '}';
    }
}
