// Cho file văn bản VANBAN.in.
// Một từ được định nghĩa là một dãy ký tự liên tiếp không có khoảng trống, dấu tab hay dấu xuống dòng. 
// Tạm thời chưa xét đến các dấu câu trong bải toán này.
// Hãy chuyển tất cả các từ về dạng chữ thường sau đó liệt kê các từ khác nhau xuất hiện trong file VANBAN.in theo thứ tự từ điển.
// Input
//     File VANBAN.in có không quá 200 dòng.
// Output
//     Ghi ra danh sách các từ khác nhau xuất hiện trong file. Mỗi từ trên một dòng theo thứ tự từ điển.
// Ví dụ
//     VANBAN.in
//     lap trinh Huong doi tuong
//     lap trinh Huong thanh phan
//     Output
//     doi
//     huong
//     lap
//     phan
//     thanh
//     trinh
//     tuong

// ptit/Main.java

package com.example.ptit;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}


// ptit/WordSet.java

package com.example.ptit;
import java.io.*;
import java.util.*;

public class WordSet {
    private Set<String> set;
    public WordSet(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        set = new TreeSet<>();
        while (sc.hasNext()) {
            set.add(sc.next().toLowerCase());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (String i : set) {
            s += i + "\n";
        }
        return s;
    }
}

