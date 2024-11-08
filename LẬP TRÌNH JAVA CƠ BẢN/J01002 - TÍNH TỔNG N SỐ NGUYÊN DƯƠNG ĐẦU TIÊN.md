Cho số nguyên dương N. 
Hãy tính S = 1 + 2 + ... + N

**Input:**
- Dòng đầu ghi số bộ test, không quá 10
- Mỗi dòng ghi một số nguyên dương N, không quá 10^9

**Output:**
- Với mỗi test, ghi kết quả trên một dòng.

**Ví dụ**
|Input|Output|
|-----|------|
|2||
|10|55|
|20|210|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long res = (1 + a) * a / 2;
            System.out.println(res);
        }
    }
}
```

