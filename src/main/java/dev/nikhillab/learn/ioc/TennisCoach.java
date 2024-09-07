/**
 * 
 */
package dev.nikhillab.learn.ioc;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		
		return "Practice Tennis for 45 min";
	}

}
