Cho hai số nguyên không âm a và b. Hãy tính ab.
Nếu kết quả quá lớn hãy chia dư cho 109 + 7.
**Input**
Gồm không quá 20 bộ test, mỗi test ghi trên một dòng hai số a,b; a không quá 9 chữ số, b không quá 18 chữ số.
Input kết thúc khi a = b = 0
**Output**
Với mỗi test ghi ra kết quả tính được trên một dòng.

```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static final int MOD = (int) 1e9 + 7;

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % MOD;
        }
        long tmp = pow(a, b / 2);
        if (b % 2 == 0) {
            return (tmp * tmp) % MOD;
        }
        return (((tmp * tmp) % MOD) * a) % MOD;
    }

    public static void main(String[] args) {
        while (true) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0) {
                return;
            }
            System.out.println(pow(a, b));
        }
    }
}
```

