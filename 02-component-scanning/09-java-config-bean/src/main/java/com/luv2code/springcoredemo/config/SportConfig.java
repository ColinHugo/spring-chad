package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.ICoach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean( "aquatic" )
    public ICoach swimCoach() {
        return new SwimCoach();
    }
}
