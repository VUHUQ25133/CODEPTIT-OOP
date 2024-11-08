Viết chương trình tính bội số chung nhỏ nhất của hai số nguyên dương lớn (có thể đến 500 chữ số)
**Input:**
Dòng 1 ghi số bộ test. Mỗi bộ test gồm 2 dòng, mỗi dòng ghi một số.
**Output:**
Với mỗi bộ test ghi ra kết quả trên một dòng.
```java
package com.example.ptit;

import java.util.*;
import java.math.BigInteger;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void testCase() {
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger mul = a.multiply(b);
        BigInteger gcd = a.gcd(b);
        BigInteger lcm = mul.divide(gcd);
        System.out.println(lcm);
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

