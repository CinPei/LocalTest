package com.cin.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getNPrime {
    private static List<Integer> primeList = new ArrayList<Integer>();
    public static void main(String[] args) {
        System.out.print("请输入N的值:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNPrime(n));

    }

    private static int getNPrime(int n) {
        int cursor = 0;
        while (primeList.size() < n){
            if (isPrime(cursor)) primeList.add(cursor);
            cursor++;
        }
        System.out.println(primeList);
        return primeList.get(primeList.size() - 1);
    }

    private static boolean isPrime(int num){
        if (num <= 1) return true;
        for (int i = 2; i * i <= num; i++){
            if (!primeList.contains(i)){
                continue;
            }
            if (num % i == 0) return false;
        }
        return true;
    }
}
