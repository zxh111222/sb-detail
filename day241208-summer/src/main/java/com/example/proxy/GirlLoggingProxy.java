package com.example.proxy;

import java.time.LocalDateTime;

public class GirlLoggingProxy implements Flyable {

    Girl girl;

    public GirlLoggingProxy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void fly() {
        System.out.println("用户 admin 开始访问该方法，地点：xm，时间：" + LocalDateTime.now());

        girl.fly();

        System.out.println("用户 admin 结束访问该方法，地点：xm，时间：" + LocalDateTime.now());
    }
}
