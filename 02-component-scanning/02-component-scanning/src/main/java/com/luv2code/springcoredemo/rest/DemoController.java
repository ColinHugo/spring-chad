package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define private field for the dependency
    private ICoach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController( ICoach myCoach ) {
        this.myCoach = myCoach;
    }

    @GetMapping( "/dailyworkout" )
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
