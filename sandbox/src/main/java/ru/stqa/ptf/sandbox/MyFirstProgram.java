package ru.stqa.ptf.sandbox;

import java.sql.SQLOutput;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("Alexandra");

        double len = 4;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
    }

    public static void hello(String somebody) {
        System.out.println("Hello " + somebody + "!");
    }

    public static double area(double len) {
        return Math.pow(len, 2);
    }

    public static double area(double a, double b) {
        return  a * b;
    }
}