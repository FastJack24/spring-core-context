package com.fastjack24.configurations;

import com.fastjack24.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.ConstructorProperties;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.fastjack24.annotations")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic musicBean() {
        return new ClassicalMusic();
    }

    @Bean
    public ClassicalMusic musicBeanClassical() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic musicBeanRock() {
        return new RockMusic();
    }

    @Bean
    public RapMusic musicBeanRap() {
        return new RapMusic();
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicBeanClassical());
    }

    @Bean
    public List<Music> musicList() {
        return Arrays.asList(musicBeanClassical(), musicBeanRock(), musicBeanRap());
    }
}
