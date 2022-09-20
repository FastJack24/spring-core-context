package com.fastjack24;

public class MusicPlayer {
    private Music music;

    public MusicPlayer(Music music) {
        // There we delegate dependency (and object) creation and depend on abstraction using strategy pattern.
        // If we create an object and pass it with Spring it's called dependency injection.
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

}
