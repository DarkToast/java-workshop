package concurrency.health;

import com.google.inject.Inject;
import util.Sleep;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class CreditServiceHealthCheck extends HealthCheck {

    @Inject
    public CreditServiceHealthCheck(final ExecutorService executorService) {
        super("creditService", executorService);
    }

    @Override
    protected Supplier<CheckResult> getCheckSupplier() {
        return () -> {
            Sleep.sleep(1000);
            return new CheckResult("creditService", CheckResult.Status.DOWN, Optional.of("The credit service ist not available"));
        };
    }
}
