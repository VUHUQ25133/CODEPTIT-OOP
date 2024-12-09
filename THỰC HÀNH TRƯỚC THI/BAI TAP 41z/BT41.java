package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }

    public boolean isPrime() {
        return isPrime((Integer) first) && isPrime((Integer) second);
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}

class Student {

    public static int NUM_STUDENT = 1;
    private String id, name, lop, dob;
    private float gpa;

    public Student(String name, String lop, String dob, float gpa) throws ParseException {
        this.id = "B20DCCN" + String.format("%03d", NUM_STUDENT++);
        this.name = name;
        this.lop = lop;
        this.gpa = gpa;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        this.dob = formatter.format(formatter.parse(dob));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }
}
class Subject implements Comparable<Subject> {

    private String id, name;
    private int stc;

    public Subject(String id, String name, int stc) {
        this.id = id;
        this.name = name;
        this.stc = stc;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + stc;
    }

    @Override
    public int compareTo(Subject o) {
        return name.compareTo(o.getName());
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        Subject[] subjects = new Subject[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int stc = Integer.parseInt(sc.nextLine());
            subjects[i] = new Subject(id, name, stc);
        }
        Arrays.sort(subjects);
        for (Subject i : subjects) {
            System.out.println(i);
        }
    }
}

