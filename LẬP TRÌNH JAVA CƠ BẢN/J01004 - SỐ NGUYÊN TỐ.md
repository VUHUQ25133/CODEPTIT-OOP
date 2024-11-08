Viết chương trình kiểm tra một số nguyên dương có phải số nguyên tố hay không. 

**Input:**
- Dòng đầu của dữ liệu vào ghi số bộ test. 
- Mỗi dòng tiếp theo có một nguyên dương không quá 9 chữ số.

**Output:**
- Kết quả in ra YES nếu đó là số nguyên tố, in ra NO nếu ngược lại.

**Ví dụ**
|Input|Output|
|-----|------|
| 3   |      |
|123456|NO   |
|997  |YES   |
|111111111|NO|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void testCase() {
        int a = sc.nextInt();
        if (isPrime(a)) {
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
    
    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T-- > 0) {
            testCase();
        }
    }
}
```

