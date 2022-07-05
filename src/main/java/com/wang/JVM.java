package com.wang;

public class JVM {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = new String("a") + new String("b");
        String intern = s2.intern();
        System.out.println(intern == s2);
        System.out.println(intern == s1);

    }
}
