Cho số nguyên dương N. Hãy kiểm tra xem N có thỏa mãn đồng thời hai tính chất sau đây hay không?
Tổng chữ số của N chia hết cho 10
Các chữ số cạnh nhau đều khác nhau đúng 2 đơn vị
**Input**
Dòng đầu ghi số bộ test. Mỗi bộ test ghi trên một dòng số nguyên dương N. N có ít nhất 3 chữ số nhưng không quá 18 chữ số.
**Output**
Ghi ra YES hoặc NO tùy thuộc kết quả kiểm tra

```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean isOk(char a, char b) {
        int x = a - '0';
        int y = b - '0';
        return Math.abs(x - y) == 2;
    }

    public static void testCase() {
        String s = sc.next();
        for (int i = 1; i < s.length(); i++) {
            if (!isOk(s.charAt(i), s.charAt(i - 1))) {
                System.out.println("NO");
                return;
            }
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        if (sum % 10 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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

