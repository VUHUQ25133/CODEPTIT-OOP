package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Main {
    public static void main(String[] args) throws InputMismatchException{
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng giám khảo
        int n = sc.nextInt();

        // Khởi tạo các biến min, max và mảng lưu điểm
        double minScore = 10.0;
        double maxScore = 0.0;
        double[] scores = new double[n];

        // Nhập điểm và tìm min, max
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] < minScore) {
                minScore = scores[i];
            }
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        // Tính tổng, bỏ qua min và max
        double sum = 0.0;
        int count = 0;
        for (double score : scores) {
            if (score != minScore && score != maxScore) {
                sum += score;
                count++;
            }
        }

        // Tính trung bình
        double average = sum / count;

        // In kết quả
        System.out.printf("%.2f", average);
    }
}