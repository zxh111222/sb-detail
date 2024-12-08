package com.example.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    @Test
    public void testGirl() {
        new Girl().fly();
    }

    @Test
    public void testGirl2() {
        new Girl2().fly();
    }

    @Test
    public void GirlTimerProxy() {
        Girl target = new Girl();
        new GirlTimerProxy(target).fly();
    }

    @Test
    public void GirlLoggingProxy() {
        Girl target = new Girl();
        new GirlLoggingProxy(target).fly();
    }

    @Test
    @DisplayName("即统计时间，也记录日志（先日志、再时间）")
    void testGirlLoggingAndTimer() {
        Girl target = new Girl();
        GirlTimerProxy girlTimerProxy = new GirlTimerProxy(target);
        GirlLoggingProxy girlLoggingProxy = new GirlLoggingProxy(girlTimerProxy);
        girlLoggingProxy.fly();
    }

    @Test
    @DisplayName("即统计时间，也记录日志（先时间、再日志）")
    void testGirlTimerAndLogging() {
        Girl target = new Girl();
        GirlLoggingProxy girlLoggingProxy = new GirlLoggingProxy(target);
        GirlTimerProxy girlTimerProxy = new GirlTimerProxy(girlLoggingProxy);
        girlTimerProxy.fly();
    }

    // 思考1：如果被代理的对象不止一个方法，还有10个其他方法，或者未知个数的方法；
    // 思考2：再往外走一层，如果想代理的对象不止 Girl/Flyable，还是10个其他的类型，或者任何类型的对象；
    // 又该如何处理，如何灵活的处理

    @Test
    @DisplayName("测试动态代理")
    void testDynamicProxy() {
        Flyable flyable = (Flyable) MyProxy.newProxyInstance();

        flyable.fly();
    }

}
