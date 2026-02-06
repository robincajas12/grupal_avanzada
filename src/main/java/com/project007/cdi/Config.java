package com.project007.cdi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class Config {

    private ExecutorService executor;

    @PostConstruct
    public void init() {
        executor = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }

    @PreDestroy
    public void destroy() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
    }

    @Produces
    @ApplicationScoped
    public ExecutorService executorService() {
        return executor;
    }
}
