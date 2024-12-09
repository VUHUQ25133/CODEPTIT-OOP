package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        TreeSet<Integer> ts = new TreeSet<>();
        int[] cnt = new int[10005];
        while (sc.hasNext()) {
            int x = sc.nextInt();
            cnt[x]++;
            ts.add(x);
        }
        for (Integer x : ts) {
            System.out.println(x + " " + cnt[x]);
        }
    }
}
