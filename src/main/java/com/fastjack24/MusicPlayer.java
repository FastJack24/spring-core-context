package com.fastjack24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;
    private List<Music> musicList;

    public MusicPlayer() {
    } // If we delete constructor argument in xml, this thing is needed if we have no-arg constructor

    public MusicPlayer(Music music) {
        // There we delegate dependency (and object) creation and depend on abstraction using strategy pattern.
        // If we create an object and pass it with Spring it's called dependency injection.
        this.music = music;
    }

    @Autowired
    public void setMusic(@Qualifier("musicBeanRap") Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    @Value("Andrew's PLAYER")
    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    @Value("${musicPlayer.volume}")
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    @Autowired
    public void setMusicList(@Qualifier("musicList") List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public void playMusicList() {
        for (Music music: musicList) {
            System.out.println(music.getSong());
        }
    }
}
