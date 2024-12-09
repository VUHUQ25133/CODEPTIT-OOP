package com.example.ptit;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String longestWord = "";
        int maxLength = 0;

        // Đọc luồng văn bản
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Tách từ trong dòng
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > maxLength) {
                    longestWord = word;
                    maxLength = word.length();
                }
            }
        }
        scanner.close();

        // In kết quả
        System.out.println(longestWord + " - " + maxLength);
    }
}