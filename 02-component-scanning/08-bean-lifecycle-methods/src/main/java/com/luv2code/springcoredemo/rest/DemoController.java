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

    @Autowired
    public DemoController( @Qualifier( "cricketCoach" ) ICoach coach ) {
        System.out.println( "In constructor: " + getClass().getSimpleName() );
        this.myCoach = coach;
    }

    @GetMapping( "/dailyworkout" )
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
