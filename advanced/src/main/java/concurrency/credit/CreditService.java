package concurrency.credit;

import util.Sleep;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;

public class CreditService {
    public CompletableFuture<CreditRating> rateAync(final Customer customer) {
        return CompletableFuture.supplyAsync(() -> {
            SecureRandom random = new SecureRandom();
            int sleep = random.nextInt(6) * 1000;

            System.out.println("Sleeping for  " + sleep + " seconds on Thread " + Thread.currentThread().getName());
            Sleep.sleep(sleep);
            return new CreditRating(customer, random.nextInt(99));
        });
    }

    public CreditRating rateBlocked(final Customer customer) {
        SecureRandom random = new SecureRandom();
        int sleep = random.nextInt(6) * 1000;

        System.out.println("Sleeping for  " + sleep + " seconds on Thread " + Thread.currentThread().getName());
        Sleep.sleep(sleep);
        return new CreditRating(customer, random.nextInt(99));
    }
}
