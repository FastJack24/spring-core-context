package com.fastjack24;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        ); // MUST be in resource folder

        TestBean testBean = context.getBean("testBean", TestBean.class);

        System.out.println(testBean.getName());
    }
}
