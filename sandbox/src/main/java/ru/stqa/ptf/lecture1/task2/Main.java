package ru.stqa.ptf.lecture1.task2;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(-2.3, 4);
        Point b = new Point(8.5, 0.7);

        double dist = a.distance(b);

        System.out.print("The distance between ");
        a.printCoordinates();
        System.out.print(" and ");
        b.printCoordinates();
        System.out.print(" equals " + dist);
    }
}

