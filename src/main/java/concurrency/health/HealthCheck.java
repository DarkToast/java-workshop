package concurrency.health;

import util.Sleep;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public abstract class HealthCheck {
    private final String name;
    private final Supplier<CheckResult> checkSupplier;
    private final Executor executor;

    public HealthCheck(final String name, final Executor executor) {
        this.name = name;
        this.executor = executor;
        this.checkSupplier = getCheckSupplier();
    }

    abstract protected Supplier<CheckResult> getCheckSupplier();

    public CompletableFuture<CheckResult> check() {
        Supplier<CheckResult> timeout = () -> {
            Sleep.sleep(3000);
            return new CheckResult(name, CheckResult.Status.DOWN, Optional.of(name + " connection timed out after 3s."));
        };

        return CompletableFuture
            .supplyAsync(checkSupplier, executor)
            .applyToEither(CompletableFuture.supplyAsync(timeout, executor), (result) -> result);
    }
}
