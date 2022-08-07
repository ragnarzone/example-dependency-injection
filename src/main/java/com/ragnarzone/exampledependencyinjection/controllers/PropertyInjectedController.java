package com.ragnarzone.exampledependencyinjection.controllers;

import com.ragnarzone.exampledependencyinjection.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return  greetingService.sayGreeting();
    }
}
