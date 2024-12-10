package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc n (tổng số sản phẩm) và m (số sản phẩm lỗi) & danh sách các sản phẩm lỗi
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> errors = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            errors.add(sc.nextInt());
        }

        // Tìm các đoạn lỗi liên tiếp
        StringBuilder errorSegments = new StringBuilder("Errors: ");
        for (int i = 0; i < errors.size(); i++) {
            int start = errors.get(i);
            while (i < errors.size() - 1 && errors.get(i + 1) == errors.get(i) + 1) {
                i++;
            }
            int end = errors.get(i);
            if (start == end) {
                errorSegments.append(start).append(", ");
            } else {
                errorSegments.append(start).append("-").append(end).append(", ");
            }
        }

        // Xác định danh sách các sản phẩm không lỗi
        Set<Integer> corrects = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            corrects.add(i);
        }
        corrects.removeAll(errors);

        // Tìm các đoạn sản phẩm chính xác liên tiếp
        StringBuilder correctSegments = new StringBuilder("Corrects: ");
        List<Integer> correctList = new ArrayList<>(corrects);
        for (int i = 0; i < correctList.size(); i++) {
            int start = correctList.get(i);
            while (i < correctList.size() - 1 && correctList.get(i + 1) == correctList.get(i) + 1) {
                i++;
            }
            int end = correctList.get(i);
            if (start == end) {
                correctSegments.append(start).append(", ");
            } else {
                correctSegments.append(start).append("-").append(end).append(", ");
            }
        }

        // Loại bỏ dấu phẩy cuối cùng và thay bằng "and"
        if (errorSegments.length() > 8) {
            errorSegments.setLength(errorSegments.length() - 2);
            int lastComma = errorSegments.lastIndexOf(", ");
            if (lastComma != -1) {
                errorSegments.replace(lastComma, lastComma + 2, " and ");
            }
        }

        if (correctSegments.length() > 10) {
            correctSegments.setLength(correctSegments.length() - 2);
            int lastComma = correctSegments.lastIndexOf(", ");
            if (lastComma != -1) {
                correctSegments.replace(lastComma, lastComma + 2, " and ");
            }
        }

        // In kết quả
        System.out.println(errorSegments);
        System.out.println(correctSegments);
    }
}