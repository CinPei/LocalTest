package com.cin.interview;

import com.fasterxml.jackson.databind.MappingIterator;

import java.util.Scanner;

public class shangjiaosuo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        Long l = Long.valueOf(s);
        while (true){
            l++;
            if (isLucky(String.valueOf(l))) {
                System.out.println(l);
                break;
            }
        }
    }

    private static boolean isLucky(String s){
        return s.charAt(0) + s.charAt(1) + s.charAt(2) == s.charAt(3) + s.charAt(4) + s.charAt(5);
    }

}
