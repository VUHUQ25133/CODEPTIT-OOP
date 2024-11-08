
Viết chương trình tính tổng *S = 1 + 1.2 + 1.2.3 +   ...+1.2.3...n.*
Dữ liệu vào chỉ có một dòng ghi số n không quá 20.
Kết quả cũng được ghi trên một dòng duy nhất.

**Ví dụ**
|Input|Output|
|-----|------|
|3|9|



```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void testCase() {
        long n = sc.nextLong();
        long t = 1, res = 0;
        for (int i = 1; i <= n; i++) {
            t *= i;
            res += t;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int T = 1;
//        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase();
        }
    }
}


```

