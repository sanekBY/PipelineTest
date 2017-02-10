package com.sashqua.pipeline.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by sashqua on 2/9/17.
 */

@ComponentScan({"com.sashqua.pipeline.thread"})
public class AppConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(5);
        pool.setMaxPoolSize(10);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

}
