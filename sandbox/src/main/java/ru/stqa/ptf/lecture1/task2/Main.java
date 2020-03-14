package ru.stqa.ptf.lecture1.task2;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(-2.3, 4);
        Point b = new Point(8.5, 0.7);

        double dist = distance(a, b);

        System.out.print("The distance between ");
        a.printCoordinates();
        System.out.print(" and ");
        b.printCoordinates();
        System.out.print(" equals " + dist);
    }

    public static double distance(Point a, Point b) {
        double d = Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
        return d;
    }
}

