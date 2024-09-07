/**
 * 
 */
package dev.nikhillab.learn.ioc;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * 
 */
@Component
@Primary
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {
	CricketCoach() {
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

		return "Practice Batting and bowling for 15 min";
	}

}
