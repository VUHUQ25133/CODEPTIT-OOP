// Cho file văn bản DATA.in
// Hãy đọc toàn bộ nội dung của file và in ra màn hình theo đúng định dạng ban đầu.
// Ví dụ:
// DATA.in
//     Lap trinh huong doi tuong voi Java
// Output
//     Lap trinh huong doi tuong voi Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}