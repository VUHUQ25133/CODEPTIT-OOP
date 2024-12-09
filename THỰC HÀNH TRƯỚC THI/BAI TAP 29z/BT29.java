package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

class Point {
    public int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Polygon {
    private Point[] p;

    public Polygon(Point[] p) {
        this.p = p;
    }

    public String getArea() {
        double area = 0.0;
        for (int i = 0; i < p.length; i++) {
            int j = (i + 1) % p.length;
            area += 0.5 * (p[i].x * p[j].y - p[j].x * p[i].y);
        }
        return String.format("%.3f", area);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("POLYGON.in"));
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Point p[] = new Point[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Point(in.nextInt(), in.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
    }
}
