package com.cin.dr.concurrent.test2;

import com.cin.dr.domain.Animal;

public class Test44 {
    public static void main(String[] args) {
        Animal.Cat cat1 = new Animal.Cat("c1", "d1");
        Animal.Cat cat2 = new Animal.Cat("c2", "d2");
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat1);
        System.out.println(Animal.Cat.e);
    }
}
