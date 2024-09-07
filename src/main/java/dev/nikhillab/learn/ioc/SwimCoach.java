package dev.nikhillab.learn.ioc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SwimCoach  implements Coach{
    public SwimCoach(){
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
