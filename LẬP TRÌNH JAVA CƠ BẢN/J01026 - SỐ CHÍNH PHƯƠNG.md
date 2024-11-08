Nhập một số nguyên dương không quá 9 chữ số. Hãy kiểm tra xem đó có phải số chính phương hay không.
Dòng đầu của dữ liệu vào ghi số bộ test, mỗi bộ test là một số nguyên dương ghi trên một dòng. 
Kết quả: ghi ra YES nếu đúng và NO nếu không.

```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean isValid(char c) {
        return c >= '0' && c <= '2';
    }

    public static void testCase() {
            int N = sc.nextInt();
            int n = (int) Math.sqrt(N);
            if (N == n * n) {
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

