package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class Company implements Comparable<Company> {

    private String id, name;
    private int count;

    public Company(String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + count;
    }

    @Override
    public int compareTo(Company o) {
        return id.compareTo(o.getId());
    }
}
class LoaiPhong implements Comparable<LoaiPhong> {

    private String line, name;

    public LoaiPhong(String line) {
        this.line = line;
        this.name = line.trim().split("\\s+")[1];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return name.compareTo(o.getName());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}

