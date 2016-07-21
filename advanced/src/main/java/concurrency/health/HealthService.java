package concurrency.health;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class HealthService {
    private final Set<HealthCheck> checks;

    @Inject
    public HealthService(Set<HealthCheck> checks) {
        this.checks = ImmutableSet.copyOf(checks);
    }

    public CompletableFuture<List<CheckResult>> getServices() {
        List<CompletableFuture<CheckResult>> futureList = checks.stream().map(HealthCheck::check).collect(Collectors.toList());
        return transformList(CompletableFuture.completedFuture(Lists.newArrayList()), futureList);
    }

    private <T> CompletableFuture<List<T>> transformList(
        CompletableFuture<List<T>> accumulator,
        List<CompletableFuture<T>> elems
    ) {
        BiFunction<List<T>, T, List<T>> combinator = (list, elem) -> { list.add(elem); return list; };
        if(elems.isEmpty()) {
            return accumulator;
        } else {
            return transformList(accumulator.thenCombine(elems.get(0), combinator), elems.subList(1, elems.size()));
        }

    }
}
