package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<String> a = (ArrayList<String>) ois1.readObject();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>) ois1.readObject();
        TreeSet<String> set = new TreeSet<>();
        for (String x : a) {
            for (Integer y : b) {
                String res = x + "" + y;
            }
        }
        for(String x:set){
            System.out.println(x);
        }
    }
}