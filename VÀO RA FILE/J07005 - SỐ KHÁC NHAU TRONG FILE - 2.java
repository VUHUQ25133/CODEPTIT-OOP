// Cho file nhị phân DATA.IN có đúng 100000 số nguyên dương, giá trị các số nhỏ hơn 1000.
// Hãy liệt kê các số khác nhau xuất hiện trong file và số lần xuất hiện của từng số đó.
// Input
//     File DATA.IN có 100000 số nguyên dương.
// Output
//     Ghi ra các số khác nhau và số lần xuất hiện theo thứ tự tăng dần
// Ví dụ:
//     DATA.IN
//     Output
//     File nhị phân theo mô tả đề bài
//     Liệt kê các số tăng dần, ví dụ: 
//     10 2
//     21 1
//     25 4

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        int[] a = new int[1000];
        for (int i = 0; i < 100000; i++) {
            a[dis.readInt()]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (a[i] > 0) {
                System.out.println(i + " " + a[i]);
            }
        }
    }
}