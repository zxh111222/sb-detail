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
    @DisplayName("即统计时间，也记录日志（先时间、再日志）")
    void testGirlTimerAndLogging() {
        // todo 思考：如何实现“即记录日志，也统计时间”的功能
        // 同时思考：如何灵活的调整“记录日志”和“统计时间”的顺序
    }

}
