Viết chương trình kiểm tra số nguyên dương N có thỏa mãn tính chất: tất cả các chữ số cạnh nhau chỉ sai khác nhau đúng một đơn vị hay không. Ví dụ: số 123212 là số thỏa mãn, số 34578 không thỏa mãn.
**Input**
Dòng đầu ghi số số test (không quá 20). Mỗi test là 1 số nguyên dương N có ít nhất 2 chữ số, nhưng không quá 18 chữ số.
**Output**
Ghi ra YES hoặc NO

```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean isOk(char a, char b) {
        int x = a - '0';
        int y = b - '0';
        return Math.abs(x - y) == 1;
    }

    public static void testCase() {
        String s = sc.next();
        for (int i = 1; i < s.length(); i++) {
            if (!isOk(s.charAt(i), s.charAt(i - 1))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) {
        int T = 1;
        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase();
        }
        }
}

```

