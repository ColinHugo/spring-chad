package com.lov2code.coolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World"
    @GetMapping( "/" )
    public String sayHello() {
        return "Hello world.";
    }

    // Expose a new endpoint for "workout"
    @GetMapping( "/workout" )
    public String getDailyWorkout() {
        return "Run a hard 5 km";
    }

    // Expose a new endpoint for "fortune"
    @GetMapping( "/fortune" )
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }

}