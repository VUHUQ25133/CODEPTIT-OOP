Cho số nguyên dương N.
Nhiệm vụ của bạn là hãy xác định xem có bao nhiêu ước số của N chia hết cho 2?
**Input:** Dòng đầu tiên là số lượng bộ test T (T ≤ 100). Mỗi bộ test gồm một số nguyên N (1 ≤ N ≤ 1e9)
**Output:** Với mỗi test, in ra đáp án tìm được trên một dòng.
**Ví dụ**
|Input|Output|
|-----|------|
|2|0|
|9|3|
|8||


```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void testCase() {
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i % 2 == 0) {
                    cnt++;
                }
                if ((n / i) % 2 == 0 && i != Math.sqrt(n)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
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

