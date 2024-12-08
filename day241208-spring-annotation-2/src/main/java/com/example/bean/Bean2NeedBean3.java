package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean2NeedBean3 {
    public Bean3 bean3;


    public Bean2NeedBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }
}
