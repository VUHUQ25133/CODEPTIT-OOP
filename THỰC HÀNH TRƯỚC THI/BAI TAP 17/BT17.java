package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Main {
    public static boolean check(int num) {
        if (num < 100) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
        ArrayList<Integer> numbers = (ArrayList<Integer>) ois.readObject();
        ois.close();

        TreeSet<Integer> result = new TreeSet<>();

        for (int num : numbers) {
            if (check(num)) {
                result.add(num);
            }
        }
        for (int num : result) {
            System.out.println(num);
        }
    }
}
