package coffeeorder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard(new LinkedList<>());


        coffeeOrderBoard.add("Tom");
        coffeeOrderBoard.add("Jack");
        coffeeOrderBoard.add("Adam");
        coffeeOrderBoard.add("Samantha");

//        System.out.println(coffeeOrderBoard.deliver());
        System.out.println();
        System.out.println(coffeeOrderBoard.deliver(3));
        System.out.println();

        coffeeOrderBoard.draw();
    }
}
