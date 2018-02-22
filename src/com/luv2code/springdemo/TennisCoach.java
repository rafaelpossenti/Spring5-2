package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("@PostConstruct");
	}
	
	//define my init method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("@PreDestroy");
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside set Injection");
		this.fortuneService = fortuneService;
	}
	
	@Autowired
	public void doAnything(FortuneService fortuneService) {
		System.out.println("inside the method doAnything");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		 this.fortuneService = fortuneService;
		
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand 	volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
