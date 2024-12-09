package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng bộ test
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String S = sc.nextLine();
            List<Character> letters = new ArrayList<>();
            int digitSum = 0; // Tổng các chữ số

            // Phân loại ký tự
            for (char c : S.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitSum += c - '0'; // Cộng giá trị số
                } else if (Character.isLetter(c)) {
                    letters.add(c);
                }
            }
            Collections.sort(letters);
            
            // In ra kết quả
            StringBuilder result = new StringBuilder();
            for (char c : letters) {
                result.append(c);
            }
            result.append(digitSum);
            System.out.println(result);
        }
    }
}