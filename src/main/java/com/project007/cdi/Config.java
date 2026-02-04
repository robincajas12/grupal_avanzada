package com.project007.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class Config {
    @Produces
    @ApplicationScoped
    ExecutorService executorService()
    {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
