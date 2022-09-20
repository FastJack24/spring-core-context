package com.fastjack24;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        ); // MUST be in resource folder

        Music music = context.getBean("musicBean", Music.class); // There we can choose an implementation in xml.
        MusicPlayer musicPlayer = new MusicPlayer(music); // We inject, not Spring.
        musicPlayer.playMusic();

        musicPlayer = context.getBean("musicPlayer", MusicPlayer.class); // DI with Spring XML configuration.
        musicPlayer.playMusic();
        System.out.println("----------");
    }
}
