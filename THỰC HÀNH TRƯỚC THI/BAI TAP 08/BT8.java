package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số phần tử
        int n = sc.nextInt();
        int[] A = new int[n];
        // Đọc dãy số
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;

        // Duyệt qua tất cả các cặp (i, j)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean valid = true;

                // Kiểm tra các phần tử ở giữa
                for (int k = i + 1; k < j; k++) {
                    if (A[k] > A[i] || A[k] > A[j]) {
                        valid = false;
                        break;
                    }
                }

                // Nếu cặp (i, j) hợp lệ, tăng bộ đếm
                if (valid) {
                    count++;
                }
            }
        }

        // In ra kết quả
        System.out.println(count);
    }
}