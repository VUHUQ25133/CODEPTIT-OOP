// Cho file nhị phân DATA.in trong đó ghi một ArrayList<Integer> gồm tối đa 100000 số nguyên, các số đều nguyên dương và không quá 106.
// Hãy tìm 10 số nguyên tố lớn nhất trong file và số lần xuất hiện của các số đó. Liệt kê 10 số theo thứ tự giảm dần.
// Input
//     File nhị phân DATA.in. Đảm bảo có nhiều hơn 10 số nguyên tố khác nhau.
// Output
//     Số 10 nguyên tố lớn nhất và số lần xuất hiện, mỗi số trên một dòng.
// Ví dụ
// DATA.in
//     File nhị phân có một ArrayList<Integer>
// Output
//     Ghi 10 số nguyên tố lớn nhất và số lần
//     Ví dụ:
//     997 19
//     29 6
//     23 41
//     19 13
//     17 17
//     13 88
//     11 230
//     7 49
//     5 169
//     3 1321

package com.example.ptit;

import java.io.*;
import java.util.*;

public class Main {

    public static final int N = (int) 1e6;
    public static int[] prime = new int[N + 1];

    public static void sieve() {
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i <= (int) 1e3; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        int[] dd = new int[N + 1];
        for (Integer i : list) {
            dd[i] += prime[i];
        }
        int dem = 0;
        for (int i = N; i >= 2; i--) {
            if (dd[i] > 0) {
                System.out.println(i + " " + dd[i]);
                dem++;
                if (dem == 10) {
                    break;
                }
            }
        }
    }
}