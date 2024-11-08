// Cho file nhị phân SONGUYEN.in trong đó ghi một ArrayList<Integer> theo kiểu object. Các giá trị đều nguyên dương và nhỏ hơn 10000.
// Hãy viết chương trình trình liệt kê các số nguyên tố khác nhau xuất hiện trong file theo thứ tự tăng dần và số lần xuất hiện của các số đó.
// Input
//     File nhị phân SONGUYEN.in
// Output
//     Ghi ra các số nguyên tố khác nhau theo thứ tự tăng dần và số lần xuất hiện.
// Ví dụ
// Input
//     File SONGUYEN.in theo mô tả đề bài
// Output
//     Danh sách các số nguyên tố tăng dần và số lần xuất hiện. Ví dụ:
//     2 17
//     11 15
//     997 8

import java.io.*;
import java.util.*;

public class Main {
    public static int[] prime = new int[10000];

    public static void sieve() {
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i <= 100; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> list = (List<Integer>) ois.readObject();
        int[] dd = new int[10000];
        for (Integer i : list) {
            dd[i] += prime[i];
        }
        for (int i = 2; i < 10000; i++) {
            if (dd[i] > 0) {
                System.out.println(i + " " + dd[i]);
            }
        }
    }
}