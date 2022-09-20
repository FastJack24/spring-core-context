package com.fastjack24;

public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public void doInit() {
        System.out.println("Doing my initialization");
    }

    public void doDestroy() {
        System.out.println("Doing my destruction");
    }
}
