package concurrency.credit;

import util.Require;

import java.util.Objects;

public class CreditRating {
    public final Customer customer;
    public final long rating;

    public CreditRating(Customer customer, int rating) {
        this.customer = Objects.requireNonNull(customer);
        this.rating = Require.require(rating, (r) -> r < 100 && r >= 0);
    }
}
