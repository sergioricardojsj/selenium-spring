package com.home.teste.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

    @Autowired
    private Settings settings;

    @PostConstruct
    public void init() {
        Config.configuration(settings);
    }

}
