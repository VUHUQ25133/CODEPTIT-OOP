Hãy phân tích một số nguyên dương thành tích các thừa số nguyên tố.   
**Dữ liệu vào:** Dòng đầu tiên ghi số bộ test. 
    Mỗi bộ test viết trên một dòng số nguyên dương n không quá 9 chữ số.
**Kết quả:** Mỗi bộ test viết ra thứ tự bộ test, sau đó lần lượt là các số nguyên tố khác nhau có trong tích, 
với mỗi số viết thêm số lượng số đó.

**Ví dụ**
|Input|Output|
|-----|------|
|3|Test 1: 2(2) 3(1) 5(1)|
|60|Test 2: 2(7)|
|128|Test 3: 2(4) 5(4)|
|10000||


```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void testCase(int t) {
        int N = sc.nextInt();
        int n = N;
        System.out.printf("Test %d: ", t);
        for (int i = 2; i <= Math.sqrt(N); i++) {
            int cnt = 0;
            while (n % i == 0) {
                cnt++;
                n /= i;
            }
            if (cnt != 0) {
                System.out.printf("%d(%d) ", i, cnt);
            }
        }
        if (n != 1) {
            System.out.printf("%d(%d) ", n, 1);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int T = 1;
        T = sc.nextInt();;
        for (int i = 1; i <= T; i++) {
            testCase(i);
        }
    }
}

```

