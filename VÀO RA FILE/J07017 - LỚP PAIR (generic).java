// Khai báo lớp Pair kiểu Generic để ghép cặp hai đối tượng bất kỳ.
// Sử dụng lớp Pair ghép cặp hai số nguyên để giải quyết bài toán sau (chú ý viết hàm main đúng theo mẫu).
// Nhập số tự nhiên N, hãy tìm cặp số nguyên tố đầu tiên có tổng là N.
// Nếu không tồn tại cặp số nguyên tố có tổng bằng N, hãy đưa ra -1.
// Input: File văn bản DATA.in
//     Dòng đầu tiên đưa vào số lượng bộ test T.
//     Những dòng kế tiếp đưa vào các bộ test. Mỗi bộ test gồm là một số N được ghi trên một dòng.
//     T, N thỏa mãn ràng buộc: 1≤T≤100; 1≤ N ≤106
// Output:
//     Đưa ra kết quả mỗi test theo từng dòng.
// Ví dụ:
// Input
//     2
//     4
//     8
// Output:
//     2 2
//     3 5

// ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(-1);
            }
        }
    }
}

// ptit/Pair.java
package com.example.ptit;

public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }

    public boolean isPrime() {
        return isPrime((Integer) first) && isPrime((Integer) second);
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}

