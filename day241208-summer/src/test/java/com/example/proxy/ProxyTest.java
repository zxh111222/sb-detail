package com.example.proxy;

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

}
