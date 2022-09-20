package com.fastjack24.annotations;

import com.fastjack24.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NewMusicPlayer {

    private Music music;

    @Autowired // It's better to mention this thing, but this is default for bean.
    public NewMusicPlayer(@Qualifier("newRockMusic") Music music) {
        this.music = music;
    }

    // Look, that Spring will only add this dependency if you explicitly tell it!!!, nothing is done otherwise.
    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
