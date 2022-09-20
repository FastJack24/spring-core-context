package com.fastjack24.annotations;

import com.fastjack24.Music;
import org.springframework.stereotype.Component;

@Component
public class NewRockMusic implements Music {
    @Override
    public String getSong() {
        return "Nothing else matter";
    }
}
