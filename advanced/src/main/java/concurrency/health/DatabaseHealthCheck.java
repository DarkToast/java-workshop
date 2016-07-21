package concurrency.health;

import com.google.inject.Inject;
import util.Sleep;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class DatabaseHealthCheck extends HealthCheck {

    @Inject
    public DatabaseHealthCheck(final ExecutorService executorService) {
        super("database", executorService);
    }

    @Override
    protected Supplier<CheckResult> getCheckSupplier() {
        return () -> {
            Sleep.sleep(4000);
            return new CheckResult("database", CheckResult.Status.UP, Optional.empty());
        };
    }
}
