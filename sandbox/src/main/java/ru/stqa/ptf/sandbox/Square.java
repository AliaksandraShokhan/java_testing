package ru.stqa.ptf.sandbox;

public class Square {
    public double l;

    public Square(double l) {
        this.l = l;
    }

    public double area() {
        return Math.pow(this.l, 2);
    }
}
