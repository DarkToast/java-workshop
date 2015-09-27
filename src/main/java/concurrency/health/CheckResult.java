package concurrency.health;

import java.util.Optional;

public class CheckResult {
    public final String serviceName;
    public final Status status;
    public final Optional<String> error;

    public CheckResult(String serviceName, Status status, Optional<String> error) {
        this.serviceName = serviceName;
        this.status = status;
        this.error = error;
    }

    public enum Status {
        UP, DOWN
    }
}
