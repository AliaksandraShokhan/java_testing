package ru.stqa.ptf.lecture1.task2;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void printCoordinates() {
        System.out.print("[" + x + "; " + y + "]");
    }

    public double distance(Point b) {
        double d = Math.sqrt(Math.pow((this.x - b.x),2) + Math.pow((this.y - b.y),2));
        return d;
    }
}
