package ru.stqa.ptf.lecture1.task2;

import org.apache.commons.math3.util.Precision;

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
        double d = Precision.round(Math.sqrt(Math.pow((this.x - b.x),2) + Math.pow((this.y - b.y),2)), 2);
        return d;
    }
}
