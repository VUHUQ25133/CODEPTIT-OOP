// Cho hai file nhị phân DATA1.in và DATA2.in trong đó ghi một ArrayList<Integer> gồm tối đa 100000 số nguyên, các số đều nguyên dương và không quá 106.
// Hãy tìm các cặp số (n, m) sao cho:
//     n < m và cả hai đều là số nguyên tố
//     n và m có xuất hiện trong file DATA1.in.
//     n và m không xuất hiện trong file DATA2.in
//     n + m = 1000000
// Các cặp số tìm được cần liệt kê theo thứ tự tăng dần của giá trị n và không lặp lại.  
// Input
//     File nhị phân DATA1.in và DATA2.in
// Output
//     Các cặp số thỏa mãn theo thứ tự tăng dần của n .
// Ví dụ
// DATA1.in và DATA2.in
//     File nhị phân có một ArrayList<Integer>
// Output
//     Ghi các cặp số thỏa mãn.
//     Ví dụ:
//     227 999773
//     22643 977357
//     25583 974417

package com.example.ptit;

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> a1 = (ArrayList<Integer>) ois1.readObject();
        Set<Integer> s1 = new TreeSet<>();
        for (int i : a1) {
            if (isPrime(i)) {
                s1.add(i);
            }
        }

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> a2 = (ArrayList<Integer>) ois2.readObject();

        final int SUM = 1000000;
        for (Integer i : s1) {
            Integer j = SUM - i;
            if (i >= j) {
                break;
            }
            if (s1.contains(j) && !a2.contains(i) && !a2.contains(j)) {
                System.out.println(i + " " + (SUM - i));
            }
        }
    }
}