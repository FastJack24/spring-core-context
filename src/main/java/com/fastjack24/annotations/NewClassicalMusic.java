package com.fastjack24.annotations;

import com.fastjack24.Music;
import org.springframework.stereotype.Component;

@Component
public class NewClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Moonlight Sonata";
    }
}
