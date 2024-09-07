/**
 * 
 */
package dev.nikhillab.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nikhillab.learn.ioc.Coach;

/**
 * 
 */
@RestController
public class CoachController {

	private Coach coach;

	/**
	 * @param coach
	 */

//	@Autowired
//	public CoachController( @Qualifier("tennisCoach") Coach coach) {
//		this.coach = coach;
//	}
	@Autowired
	public CoachController( Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/daily/workout")
	public String getDailyWorkOut() {
		return coach.getDailyWorkOut();
	}

//	/**
//	 * @param coach the coach to set
//	 */
//	@Autowired
//	public void setCoach(Coach coach) {
//		this.coach = coach;
//	}

}
