package ru.stqa.ptf.lecture1.task2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistanceCase1() {
        Point a = new Point(9,4);
        Point b = new Point(8,3);
        Assert.assertEquals(a.distance(b), 1.41);
    }

    @Test
    public void testDistanceCase2() {
        Point a = new Point(9,4);
        Point b = new Point(8,-3);
        Assert.assertEquals(a.distance(b), 7.07);
    }

    @Test
    public void testDistanceCase3() {
        Point a = new Point(9,4);
        Point b = new Point(-8,3);
        Assert.assertEquals(a.distance(b), 17.03);
    }

    @Test
    public void testDistanceCase4() {
        Point a = new Point(9,4);
        Point b = new Point(-8,-3);
        Assert.assertEquals(a.distance(b), 18.38);
    }

    @Test
    public void testDistanceCase5() {
        Point a = new Point(9,-4);
        Point b = new Point(8,3);
        Assert.assertEquals(a.distance(b), 7.07);
    }

    @Test
    public void testDistanceCase6() {
        Point a = new Point(9,-4);
        Point b = new Point(8,-3);
        Assert.assertEquals(a.distance(b), 1.41);
    }

    @Test
    public void testDistanceCase7() {
        Point a = new Point(9,-4);
        Point b = new Point(-8,3);
        Assert.assertEquals(a.distance(b), 18.38);
    }

    @Test
    public void testDistanceCase8() {
        Point a = new Point(9,-4);
        Point b = new Point(-8,-3);
        Assert.assertEquals(a.distance(b), 17.03);
    }

    @Test
    public void testDistanceCase9() {
        Point a = new Point(-9,4);
        Point b = new Point(8,3);
        Assert.assertEquals(a.distance(b), 17.03);
    }

    @Test
    public void testDistanceCase10() {
        Point a = new Point(-9,4);
        Point b = new Point(8,-3);
        Assert.assertEquals(a.distance(b), 18.38);
    }

    @Test
    public void testDistanceCase11() {
        Point a = new Point(-9,4);
        Point b = new Point(-8,3);
        Assert.assertEquals(a.distance(b), 1.41);
    }

    @Test
    public void testDistanceCase12() {
        Point a = new Point(-9,4);
        Point b = new Point(-8,-3);
        Assert.assertEquals(a.distance(b), 7.07);
    }

    @Test
    public void testDistanceCase13() {
        Point a = new Point(-9,-4);
        Point b = new Point(8,3);
        Assert.assertEquals(a.distance(b), 18.38);
    }

    @Test
    public void testDistanceCase14() {
        Point a = new Point(-9,-4);
        Point b = new Point(8,-3);
        Assert.assertEquals(a.distance(b), 17.03);
    }

    @Test
    public void testDistanceCase15() {
        Point a = new Point(-9,-4);
        Point b = new Point(-8,3);
        Assert.assertEquals(a.distance(b), 7.07);
    }

    @Test
    public void testDistanceCase16() {
        Point a = new Point(-9,-4);
        Point b = new Point(-8,-3);
        Assert.assertEquals(a.distance(b), 1.41);
    }
}
