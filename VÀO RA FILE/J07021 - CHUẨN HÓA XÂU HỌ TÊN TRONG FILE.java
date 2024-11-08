// Một xâu họ tên được coi là viết chuẩn nếu chữ cái đầu tiên mỗi từ được viết hoa, các chữ
// cái khác viết thường. Các từ cách nhau đúng một dấu cách và không có khoảng trống
// thừa ở đầu và cuối xâu. Hãy viết chương trình đưa các xâu họ tên về dạng chuẩn.
// Input - file DATA.in:
//     Có nhiều bộ test. Mỗi bộ test ghi trên một dòng xâu ký tự họ tên, không quá 80 ký tự.
//     Input kết thúc khi gặp xâu END
// Output:
//     Với mỗi bộ test ghi ra xâu ký tự họ tên đã chuẩn hóa.
// Ví dụ:
// DATA.in
//        nGuYEN    vAN    naM
//     tRan           TRUNG hiEU
//         vO le         hOA bINh
//     END
// Output
//     Nguyen Van Nam
//     Tran Trung Hieu
//     Vo Le Hoa Binh

package com.example.ptit;

import java.io.*;
import java.util.*;

public class Main {

    public static String normalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while (true) {
            String line = sc.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] list = line.trim().split("\\s+");
            String res = "";
            for (String i : list) {
                res += normalize(i) + " ";
            }
            System.out.println(res);
        }
    }
}