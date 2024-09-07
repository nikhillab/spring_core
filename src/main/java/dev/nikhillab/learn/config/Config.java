package dev.nikhillab.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.nikhillab.learn.ioc.SwimCoach;

@Configuration
public class Config {
    

    @Bean
    public SwimCoach swimCoach(){
        return new SwimCoach();
    }
}
