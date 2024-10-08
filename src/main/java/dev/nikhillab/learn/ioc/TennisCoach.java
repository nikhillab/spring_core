/**
 * 
 */
package dev.nikhillab.learn.ioc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * 
 */
@Component
public class TennisCoach implements Coach {
	TennisCoach() {
		System.out.println("Construct "+getClass().getSimpleName());
	}

	@PostConstruct
	public void initt(){
		System.out.println("PostConstruct "+getClass().getSimpleName());
	}


	@PreDestroy
	public void destroy(){
		System.out.println("PreDestroy "+getClass().getSimpleName());

	}

	@Override
	public String getDailyWorkOut() {

		return "Practice Tennis for 45 min";
	}

}
