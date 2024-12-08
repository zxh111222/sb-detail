package com.example.proxy;

public class Girl2 extends Girl{

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

        super.fly();

        long end = System.currentTimeMillis();
        System.out.println("fly time = " + (end - start));
    }
}
