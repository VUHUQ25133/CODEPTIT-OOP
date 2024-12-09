package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DAYSO.in"));

        // Đọc số lượng phần tử
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<String> numbers = new ArrayList<>();

        // Đọc từng số và lưu vào danh sách
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextLine().trim());
        }

        // Tìm số nhỏ nhất
        String minNumber = Collections.min(numbers, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        // Tìm số lớn nhất
        String maxNumber = Collections.max(numbers, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        // Tính tổng các số
        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }

        // In kết quả
        System.out.println(minNumber);
        System.out.println(maxNumber);
        System.out.println(sum);

        scanner.close();
    }
}
