package com.ragnarzone.exampledependencyinjection.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton bean!!!");
    }

    public String getMyScrope() {
        return "I'm a Singleton";
    }
}
