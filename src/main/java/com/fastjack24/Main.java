package com.fastjack24;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        ); // MUST be in resource folder

        Music music = context.getBean("musicBean", Music.class); // There we can choose an implementation in xml.
        MusicPlayer musicPlayer = new MusicPlayer(music); // We inject, not Spring.
        musicPlayer.playMusic();
        System.out.println("----------");

        musicPlayer = context.getBean("musicPlayer", MusicPlayer.class); // DI with Spring XML configuration.
        System.out.println("Player: " + musicPlayer.getName());
        System.out.println("Volume: " + musicPlayer.getVolume());
        musicPlayer.playMusic();
        System.out.println("----------");

        musicPlayer.playMusicList();
        System.out.println(musicPlayer.getMusicList() instanceof ArrayList<Music>);

        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer == secondMusicPlayer); // Same link, singleton, change scope and look.

        System.out.println("----------");
        context.close();
        System.out.println("Beans are dead!");
    }
}
