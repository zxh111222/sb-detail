package com.example.bean;

import com.example.annotation.MyComponent;

@MyComponent
public class Bean3NeedBean2 {

    public Bean2 bean2;

    public Bean3NeedBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }
}
