/**
 * 
 */
package dev.nikhillab.learn.ioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
@Primary
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		
		return "Practice Batting and bowling for 15 min";
	}

}
