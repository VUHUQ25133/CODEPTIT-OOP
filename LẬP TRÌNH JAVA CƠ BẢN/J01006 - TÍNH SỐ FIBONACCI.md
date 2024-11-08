Dãy số Fibonacci được định nghĩa theo công thức như sau:
- F1 = 1
- F2 = 1
- Fn = Fn-1 + Fn-2 với n>2

Viết chương trình tính số Fibonacci thứ n (với n không quá 92)

**Input:**
- Dòng đầu ghi số bộ test. Mỗi bộ test là một số nguyên n.

**Output:**
- Với mỗi bộ test, ghi ra số Fibonacci thứ n trên một dòng.

**Ví dụ**
|Input|Output|
|-----|------|
|3||
|2|1|
|5|5|
|20|6765|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static long[] fibo = new long[100];

    public static void init() {
        fibo[1] = fibo[2] = 1L;
        for (int i = 3; i <= 92; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }
    public static void testCase() {
        int n = sc.nextInt();
        System.out.println(fibo[n]);
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

