Tìm bội số chung nhỏ nhất và ước số chung lớn nhất của hai số nguyên dương a, b.
**Input:**
Dòng đầu tiên đưa vào T là số lượng bộ test
T dòng tiếp theo mỗi dòng có một cặp số a, b.
T, a, b thỏa mãn ràng buộc: 1 ≤ T ≤ 100; 1 ≤ a, b ≤ 1e8;
**Output**: Ghi ra kết quả tính toán

**Ví dụ**
|Input|Output|
|-----|------|
|2|10 5|
|5 10|56 2|
|14 8||



```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static long gcd(long a, long b) {
        while (b != 0) {
            long x = a % b;
            a = b;
            b = x;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void testCase() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(lcm(a, b) + " " + gcd(a, b));
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

