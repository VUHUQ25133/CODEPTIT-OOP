package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc kích thước n và m
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        // Đọc dãy a[] và b[]
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            setB.add(scanner.nextInt());
        }
        // Tính tập giao A ∩ B
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        // Tính hiệu A - B
        Set<Integer> differenceAB = new HashSet<>(setA);
        differenceAB.removeAll(setB);
        // Tính hiệu B - A
        Set<Integer> differenceBA = new HashSet<>(setB);
        differenceBA.removeAll(setA);

        // Sắp xếp và in kết quả
        printSortedSet(intersection);
        printSortedSet(differenceAB);
        printSortedSet(differenceBA);

        scanner.close();
    }

    // Hàm in tập hợp theo thứ tự tăng dần
    private static void printSortedSet(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        for (int num : sortedList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
