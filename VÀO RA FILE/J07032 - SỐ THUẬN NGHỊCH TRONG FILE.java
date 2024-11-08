// Cho hai file nhị phân DATA1.in và DATA2.in trong đó ghi một ArrayList<Integer> gồm tối đa 106 số nguyên, các số đều nguyên dương và không quá 106.
// Viết chương trình liệt kê các số thuận nghịch thỏa mãn tất cả các điều kiện sau:
//     Xuất hiện trong cả hai file DATA1.in và DATA2.in
//     Tất cả các chữ số đều lẻ
//     Số chữ số cũng là một số lẻ nhưng lớn hơn 1
//     Vì trong file có thể có rất nhiều số thỏa mãn nên người ta chỉ muốn liệt kê tối đa 10 số đầu tiên thỏa mãn các điều kiện trên theo thứ tự tăng dần. 
// Kết quả cần liệt kê số đó kèm theo tổng số lần xuất hiện của số đó trong hai file cộng lại.
// Input
//     File nhị phân DATA1.in và DATA2.in
// Output
//     Các số thỏa mãn kèm theo tổng số lần xuất hiện trong cả hai file.
// Ví dụ
// DATA1.in và DATA2.in
//     File nhị phân có một ArrayList<Integer>
// Output
// Ghi tối đa 10 số thỏa mãn theo thứ tự tăng dần.
//     Ví dụ:
//     939 7
//     11311 12

package com.example.ptit;

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        if (!sb.toString().equals(s)) {
            return false;
        }

        if (s.length() % 2 == 0 || s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        int[] dd = new int[1000001];

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> al1 = (ArrayList<Integer>) ois1.readObject();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> al2 = (ArrayList<Integer>) ois2.readObject();

        for (Integer x : al1) {
            if (isValid(x.toString()) && al2.contains(x)) {
                dd[x]++;
            }
        }

        for (Integer x : al2) {
            if (isValid(x.toString()) && dd[x] != 0) {
                dd[x]++;
            }
        }

        int dem = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (dd[i] > 0) {
                System.out.println(i + " " + dd[i]);
                dem++;
            }
            if (dem == 10) {
                break;
            }
        }
    }
}