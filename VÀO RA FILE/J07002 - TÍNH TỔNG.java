// Cho file dữ liệu dạng văn bản DATA.in có thể chứa cả số và ký tự.
// Hãy lọc ra các số nguyên int trong file và tính tổng các số đó.
// Chú ý: file dữ liệu có rất nhiều dòng với rất nhiều số và ký tự xen kẽ nhau. 
// Chỉ tính tổng các số thỏa mãn điều kiện là số kiểu int.
// Input
//     File văn bản DATA.in có không quá 1000 dòng.
// Output
//     Ghi ra giá trị tổng các số tính được.
// Ví dụ
// DATA.in
//     12 3 4 5 6 7
//     Aaa 1 1 Bbb XXX yyy 5 5
//     999999999999999999999999
//     9
// Output
//     58

package com.example.ptit;
import java.io.*;
import java.util.*;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            try {
                sum += Integer.parseInt(s);
            } catch (Exception e) {
            }
        }
        System.out.println(sum);
    }
}