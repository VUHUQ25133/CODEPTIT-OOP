// Cho file nhị phân NHIPHAN.in chứa một ArrayList<String>. Mỗi String trong danh sách có thể có nhiều từ. 
// Cho file văn bản VANBAN.in có tối đa 200 dòng văn bản.
// Hãy liệt kê các từ khác nhau xuất hiện trong cả hai file theo thứ tự xuất hiện trong file VANBAN.in.
// Input
//     Hai file NHIPHAN.in và VANBAN.in theo mô tả.
// Output
//     Danh sách các từ khác nhau xuất hiện trong cả hai file theo thứ tự xuất hiện trong file VANBAN.in. Mỗi từ trên một dòng.
//     Chú ý: Tất cả các từ đều phải chuyển về dạng chữ viết thường.

package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        List<String> list = (ArrayList<String>) ois.readObject();
        Set<String> set = new TreeSet<>();
        for (String i : list) {
            String[] words = i.trim().toLowerCase().split("\\s+");
            set.addAll(Arrays.asList(words));
        }

        Scanner sc = new Scanner(new File("VANBAN.in"));
        while (sc.hasNext()) {
            String s = sc.next().toLowerCase();
            if (set.contains(s)) {
                System.out.println(s);
                set.remove(s);
            }
        }
    }
}