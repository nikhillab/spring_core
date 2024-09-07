package dev.nikhillab.learn.ioc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseBallCoach implements Coach {
    BaseBallCoach() {
        System.out.println("creating BaseBallCoach");
    }

    @Override
    public String getDailyWorkOut() {

        return "Practice Batting for 30 min";
    }

}