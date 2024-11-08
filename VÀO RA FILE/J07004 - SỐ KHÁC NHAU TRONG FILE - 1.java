// Cho file văn bản DATA.in có không quá 100000 số nguyên dương, giá trị các số nhỏ hơn 1000.
// Hãy liệt kê các số khác nhau xuất hiện trong file và số lần xuất hiện của từng số đó.
// Input
//     File DATA.in có không quá 100000 số nguyên dương.
// Output
//     Ghi ra các số khác nhau và số lần xuất hiện theo thứ tự tăng dần
// Ví dụ
// DATA.in
// 17 20 25 20 15 10 24 17 25 17 22 11 23 18
// 14 25 12 10 12 17 21 25
// Output
// 10 2
// 11 1
// 12 2
// 14 1
// 15 1
// 17 4
// 18 1
// 20 2
// 21 1
// 22 1
// 23 1
// 24 1
// 25 4

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int[] dd = new int[1000];
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            dd[n]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (dd[i] > 0) {
                System.out.printf("%d %d\n", i, dd[i]);
            }
        }
    }
}