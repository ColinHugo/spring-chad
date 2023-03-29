package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define private field for the dependency
    private ICoach myCoach;
    private ICoach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier( "cricketCoach" ) ICoach coach,
            @Qualifier( "cricketCoach" ) ICoach anotherCoach ) {

        System.out.println( "In constructor: " + getClass().getSimpleName() );
        this.myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping( "/dailyworkout" )
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping( "/check" )
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + ( myCoach == anotherCoach );
    }

}
