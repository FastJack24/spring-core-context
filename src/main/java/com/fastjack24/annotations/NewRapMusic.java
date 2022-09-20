package com.fastjack24.annotations;

import com.fastjack24.Music;
import org.springframework.stereotype.Component;

@Component("thisIsNewRapBean") // Default name is class name starting with lower case
public class NewRapMusic implements Music {
    @Override
    public String getSong() {
        return "Rap Devil";
    }
}
