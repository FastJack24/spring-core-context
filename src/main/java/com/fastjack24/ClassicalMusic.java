package com.fastjack24;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    @PostConstruct
    public void doInit() {
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("Doing my destruction");
    }
}
