package de.darktoast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {


        Application application = new Application();
        List<String> list = new ArrayList<>();
        list.add("Foo");
        list.add("Bar");
        list.add("Baz");

        List<String> unmodifiableList = Collections.unmodifiableList(list);

        application.filter(list);
    }


    public List<String> filter(List<String> list) {
        for(String name : list) {
            System.out.println(name);
            list.remove(name);
        }

        return list;
    }
}
