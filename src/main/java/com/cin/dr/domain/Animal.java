package com.cin.dr.domain;

public class Animal {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public static class Cat {
        public static String e = "e";
        private String c;
        private String d;

        public Cat(String c, String d) {
            this.c = c;
            this.d = d;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "c='" + c + '\'' +
                    ", d='" + d + '\'' +
                    '}';
        }
    }
}
