package com.example.proxy;

/**
 * Girl3 跟目标对象实现同样的接口（代理她）
 * 从另一个角度来看，这种方式叫“聚合”，上一种方式叫“继承”
 * 思考：见 commit 消息
 */
public class GirlTimerProxy implements Flyable{

    Girl girl;

    public GirlTimerProxy(Girl target) {
        this.girl = target;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

        girl.fly();

        long end = System.currentTimeMillis();
        System.out.println("fly time = " + (end - start));
    }
}