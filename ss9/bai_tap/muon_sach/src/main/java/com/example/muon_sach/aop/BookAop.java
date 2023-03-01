package com.example.muon_sach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Aspect
@Component
public class BookAop {
    private int count=0;
    @Pointcut("execution(* com.example.muon_sach.controller.BookController.*(..))")
    public void CountLog(){}

    @After("CountLog()")
    public void count(){
        count++;
        System.out.println("Số thao tác " + count + "   vào lúc : " + LocalDateTime.now());
    }
}
