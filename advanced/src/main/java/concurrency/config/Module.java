package concurrency.config;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import concurrency.health.CreditServiceHealthCheck;
import concurrency.health.DatabaseHealthCheck;
import concurrency.health.HealthCheck;
import concurrency.health.HealthService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(ExecutorService.class).toInstance(Executors.newCachedThreadPool());

        // Health
        bind(HealthCheck.class).annotatedWith(Names.named("database")).to(DatabaseHealthCheck.class);
        bind(HealthCheck.class).annotatedWith(Names.named("creditService")).to(CreditServiceHealthCheck.class);

        Multibinder<HealthCheck> healthCheckBinder = Multibinder.newSetBinder(binder(), HealthCheck.class);
        healthCheckBinder.addBinding().to(DatabaseHealthCheck.class);
        healthCheckBinder.addBinding().to(CreditServiceHealthCheck.class);

        bind(HealthService.class);
    }
}
