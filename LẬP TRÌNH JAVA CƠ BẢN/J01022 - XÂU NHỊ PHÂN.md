Người ta tạo ra một dãy xâu ký tự nhị phân X[] trong đó:
X[1] = “0”
X[2] = “1”
X[n] = X[n-2] + X[n-1] với n>2
Với phép cộng (+) là phép nối hai xâu với nhau. 
Cho hai số tự nhiên N và K (1 < N < 93; K đảm bảo trong phạm vi của xâu X[N]).
Hãy xác định ký tự thứ K trong xâu X[N] là ký tự ‘0’ hay ký tự ‘1’.

**Input:** Dòng 1 ghi số bộ test. Mỗi bộ test ghi trên một dòng 2 số nguyên N và K.
**Output:** Ghi ra màn hình kết quả tương ứng với từng bộ test.

```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static long[] f = new long[100];

    public static void fibo() {
        f[1] = f[2] = 1L;
        for (int i = 3; i < 100; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }

    public static char devide(int n, long k) {
        if (n == 1) {
            return '0';
        }
        if (n == 2) {
            return '1';
        }
        if (k <= f[n - 2]) {
            return devide(n - 2, k);
        }
        return devide(n - 1, k - f[n - 2]);
    }

    public static void testCase() {
        int n = sc.nextInt();
        long k = sc.nextLong();
        System.out.println(devide(n, k));
    }
    public static void main(String[] args) {
        int T = 1;
        fibo();
        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase();
        }
    }
}

```

