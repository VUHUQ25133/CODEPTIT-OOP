package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

class WordSet {
    private Set<String> words;

    public WordSet(String line) {
        words = new TreeSet<>();                                                    // TreeSet để tự động sắp xếp theo thứ tự từ điển
        String[] splitWords = line.trim().toLowerCase().split("\\s+");        // Tách từ
        for (String word : splitWords) {
            words.add(word);                                                         // Thêm từng từ vào tập
        }
    }
    @Override
    public String toString() {
        return String.join(" ", words);
    }

    // Phương thức hợp hai tập từ
    public WordSet union(WordSet other) {
        WordSet result = new WordSet("");
        result.words.addAll(this.words);        // Thêm tất cả từ của tập hiện tại
        result.words.addAll(other.words);       // Thêm tất cả từ của tập đối số
        return result;
    }

    // Phương thức giao hai tập từ
    public WordSet intersection(WordSet other) {
        WordSet result = new WordSet("");
        for (String word : this.words) {
            if (other.words.contains(word)) {
                result.words.add(word);         // Chỉ thêm từ có trong cả hai tập
            }
        }
        return result;
    }
}

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        WordSet ws1 = new WordSet(line1);
        WordSet ws2 = new WordSet(line2);

        System.out.println(ws1.union(ws2));
        System.out.println(ws1.intersection(ws2));

        sc.close();
    }
}
