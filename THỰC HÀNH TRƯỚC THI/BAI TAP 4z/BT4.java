package com.example.ptit;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng bộ test
        int T = scanner.nextInt();
        scanner.nextLine(); // Bỏ dòng trống

        for (int t = 0; t < T; t++) {
            String n = scanner.nextLine(); // Đọc số N

            BigInteger tich = BigInteger.ONE; // Tích chữ số ở vị trí chẵn
            int tong = 0; // Tổng chữ số ở vị trí lẻ
            boolean check = false; // Đánh dấu nếu có chữ số khác 0 ở vị trí chẵn

            // Duyệt qua từng chữ số
            for (int i = 0; i < n.length(); i++) {
                int digit = n.charAt(i) - '0'; // Chuyển ký tự thành số

                if (i % 2 == 0) { // Vị trí chẵn
                    if (digit != 0) {
                        tich = tich.multiply(BigInteger.valueOf(digit));
                        check = true;
                    }
                } else { // Vị trí lẻ
                    tong += digit;
                }
            }

            // Nếu không có chữ số khác 0 ở vị trí chẵn, tích là 0
            if (!check) {
                tich = BigInteger.ZERO;
            }

            // In kết quả
            System.out.println(tich + " " + tong);
        }

        scanner.close();
    }
}