package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return '(' + String.valueOf(this.first) + ',' + String.valueOf(this.second) + ')';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        ArrayList<Pair<Integer, Integer>> edge = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i][j] == 1 && i < j) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    edge.add(pair);
                }
            }
        }
        for(Pair<Integer, Integer> x:edge){
            System.out.println(x);
        }
    }
}
