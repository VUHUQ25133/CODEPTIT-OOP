package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng bộ test
        int T = scanner.nextInt();

        while (T-- > 0) {
            // Đọc số lượng phần tử
            int N = scanner.nextInt();
            int[] A = new int[N];
            // Đọc mảng
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            // Đếm tần suất xuất hiện
            Map<Integer, Integer> fm = new LinkedHashMap<>();
            for (int num : A) {
                fm.put(num, fm.getOrDefault(num, 0) + 1);
            }

            // Chuyển dữ liệu sang danh sách để sắp xếp
            List<Integer> res = new ArrayList<>(fm.keySet());

            // Sắp xếp theo tần suất và giữ thứ tự xuất hiện
            res.sort((o1, o2) -> {
                int f1 = fm.get(o1);
                int f2 = fm.get(o2);
                if (f1 == f2) { // Giữ nguyên thứ tự xuất hiện
                    return 0;
                }
                // Sắp xếp giảm dần theo tần suất
                return f2 - f1;
            });

            // Xây dựng dãy số theo thứ tự đã sắp xếp
            List<Integer> result = new ArrayList<>();
            for (int num : res) {
                for (int i = 0; i < fm.get(num); i++) {
                    result.add(num);
                }
            }

            // In kết quả
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}