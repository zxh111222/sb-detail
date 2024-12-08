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
    public void testGirl3() {
        Girl target = new Girl();
        new GirlTimerProxy(target).fly();
    }

}
