package com.example.proxy;

import java.util.Random;

/**
 *  挥着翅膀的女孩
 */
public class Girl implements Flyable {

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

        System.out.println("Believe me I can fly, I am singing in the sky...");
        try {
            Thread.sleep(new Random().nextInt(2 * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("fly time = " + (end - start));
    }
}
