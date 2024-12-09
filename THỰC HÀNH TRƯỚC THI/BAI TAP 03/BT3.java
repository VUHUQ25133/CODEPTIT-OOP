package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);


    // tìm ước nguyên tố nhỏ nhất của các số
    public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static void testCase() {
        long n = sc.nextLong();
        long res = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (isPrime(n / i)) {
                    System.out.println(n / i);
                    return;
                }
                if (isPrime(i)) {
                    res = i;
                }
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int T = 1;
        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase();
        }
    }
}