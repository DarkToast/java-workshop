package interfaces;

import java.util.Date;

public class Customer implements Linked {
    public final String name;
    public final String surname;
    public final Date birthday;

    public Customer(String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
}
