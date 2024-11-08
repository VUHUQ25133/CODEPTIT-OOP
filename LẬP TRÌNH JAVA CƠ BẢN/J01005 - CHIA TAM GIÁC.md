Cho một tam giác cân có độ dài đáy bằng 1 và chiều cao bằng H. Bạn cần chia tam giác này thành N phần có diện tích bằng nhau và song song với đáy.
**(ảnh)**
Hãy in ra N-1 số là khoảng cách từ lát cắt thứ i tới đỉnh của tam giác.

**Input:**
- Dòng đầu tiên là số lượng bộ test T (T ≤ 100).
- Mỗi test gồm 2 số nguyên N và H (2 ≤ ≤ N ≤ 1000, 1 ≤ H ≤ 100 000).

**Output:**
- Với mỗi test, in ra đáp án tìm được trên một dòng với 6 chữ số sau dấu phảy.

**Ví dụ**
|Input|Output|
|-----|------|
| 2||
|3 2|1.154701 1.632993|
|2 100000|70710.678119|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void testCase() {
        int n = sc.nextInt();
        int h = sc.nextInt();
        for (double i = 1d; i < n; i++) {
            System.out.printf("%.6f ", Math.sqrt(i / n) * h);
        }
        System.out.println();
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

