package com.example.ptit;
import java.io.*;
import java.util.*;

public class Main {
    // Kiểm tra xem từ có hợp lệ không
    private static boolean isValidWord(String word) {
        // Kiểm tra từ có chứa ký tự số
        if (!word.matches(".*\\d.*")) {
            return false;
        }

        // Kiểm tra từ không chứa các dấu câu
        String invalidChars = "[.,!?:]";
        if (word.matches(".*" + invalidChars + ".*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // Đọc file
        BufferedReader br = new BufferedReader(new FileReader("VANBAN.in"));
        Set<String> validWords = new HashSet<>();
        String line;

        while ((line = br.readLine()) != null) {
            // Tách từ trong dòng
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (isValidWord(word)) {
                    validWords.add(word);
                }
            }
        }

        br.close();

        // Chuyển Set thành List và sắp xếp theo thứ tự từ điển
        List<String> sortedWords = new ArrayList<>(validWords);
        Collections.sort(sortedWords);

        // In kết quả
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}