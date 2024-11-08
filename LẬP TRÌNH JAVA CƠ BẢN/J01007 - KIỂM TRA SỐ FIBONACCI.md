Cho số nguyên dương n. 
Hãy kiểm tra xem n có phải là số trong dãy Fibonacci hay không?

**Input:**
- Dòng đầu tiên đưa vào số lượng bộ test T.
- Những dòng kế tiếp đưa vào các bộ test. Mỗi bộ test là một số nguyên dương n.
- T, n thỏa mãn ràng buộc :1 ≤ T ≤ 100; 0 ≤ n ≤ 1e18.

**Output:**
- Đưa ra “YES” hoặc “NO” tương ứng.

**Ví dụ**
|Input|Output|
|-----|------|
|2||
|8|YES|
|15|NO|


```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static long[] fibo = new long[100];

    public static void init() {
        fibo[0] = 0L; fibo[1] = 1L;
        for (int i = 2; i < 100; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }
    public static boolean isFibo(long n) {
        for (long i : fibo) {
            if (i == n) {
                return true;
            } else if (i > n) {
                return false;
            }
        }
        return false;
    }
    public static void testCase() {
        long n = sc.nextLong();
        if (isFibo(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static void main(String[] args) {
        int T = 1;
        init();
        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase();
        }
    }
}
```

