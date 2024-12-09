package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); // Đọc số lượng bộ test
        while (T-- > 0) {
            String[] ar = sc.nextLine().trim().split("\\s+"); // Tách các từ trong xâu
            // Đảo ngược thứ tự các từ trong mảng
            Collections.reverse(java.util.Arrays.asList(ar));
            // In kết quả
            for (String i : ar) {
                System.out.print(i + " ");
            }
            System.out.println(); // In xuống dòng sau mỗi bộ test
        }
    }
}
