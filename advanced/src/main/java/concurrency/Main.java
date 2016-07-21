package concurrency;

import com.google.inject.Guice;
import com.google.inject.Injector;
import concurrency.config.Module;
import concurrency.health.CheckResult;
import concurrency.health.HealthService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Injector injector = Guice.createInjector(new Module());
        ExecutorService executorService = injector.getInstance(ExecutorService.class);

        HealthService healthService = injector.getInstance(HealthService.class);

        Consumer<List<CheckResult>> healthListConsumer = (list) -> {
            Function<CheckResult, String> mapper = result ->
                    "Service '" + result.serviceName +
                    "' has status '" + result.status +
                    "' with error '" + result.error.orElse("") + "'";

            list.stream().map(mapper).forEach(System.out::println);
        };

        long start = System.currentTimeMillis();
        healthService.getServices().thenAcceptAsync(healthListConsumer).join();
        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) / 1000);

        executorService.shutdown();
    }
}
