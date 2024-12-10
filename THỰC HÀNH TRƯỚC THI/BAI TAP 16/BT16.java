package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();

        for (String s : list) {
            StringBuilder bin = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '0' || c == '1') {
                    bin.append(c);
                }
            }

            long result = Long.parseLong(bin.toString(), 2);
            System.out.println(bin.toString() + " " + result);
        }
    }
}
