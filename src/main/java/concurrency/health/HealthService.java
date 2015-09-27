package concurrency.health;

import com.google.common.collect.Lists;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HealthService {
    @Inject
    @Named("creditService")
    private HealthCheck creditServiceHealtCheck;

    @Inject
    @Named("database")
    private HealthCheck databaseHealthCheck;


    public CompletableFuture<List<CheckResult>> getServices() {
        CompletableFuture<CheckResult> creditF = creditServiceHealtCheck.check();
        CompletableFuture<CheckResult> databaseF = databaseHealthCheck.check();

        return creditF.thenCombineAsync(databaseF, (credit, database) -> Lists.newArrayList(credit, database));
    }
}
