package com.example.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class DemoAdvice {

    @Pointcut("execution(void com.example.dao.BlogRepositoryImpl.save())")
    private void pt(){}

    @Before("pt()")
    public void before(){
        System.out.println("执行方法之前，记录当前用户的身份，操作时间等日志信息");

    }


}
