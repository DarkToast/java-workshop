package interfaces;

import com.google.gson.Gson;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Max", "Mustermann", new Date());

        customer.addLink("foo", "http://www.google.de", false);

        Gson gson = new Gson();
        System.out.println(gson.toJson(customer));
    }
}
