package com.example.rest_api;

import com.example.rest_api.model.CurrencyForm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@EnableAsync
public class RequestThreadsRunner{
    private final RestService restService;

    public RequestThreadsRunner(RestService restService) {
        this.restService = restService;
    }

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }


    public void run(CurrencyForm currencyForm, String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<Float> page1 = restService.getCurrencyRates(args[0], currencyForm);
        CompletableFuture <Float> page2 = restService.getCurrencyRates(args[1], currencyForm);
        CompletableFuture <Float> page3 = restService.getCurrencyRates(args[2], currencyForm);
        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3).join();
        System.out.println(page1.get());

    }


}
