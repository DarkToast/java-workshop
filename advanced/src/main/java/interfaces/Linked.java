package interfaces;

import java.util.HashMap;
import java.util.Map;

public interface Linked {
    Map<String, Link> _links = new HashMap<>();

    default void addLink(String name, String href, boolean templated) {
        _links.put(name, new Link(href, templated));
    }

    default Map<String, Link> getLinks() {
        return _links;
    }
}
