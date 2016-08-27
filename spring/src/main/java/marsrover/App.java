package marsrover;

import marsrover.world.Point;

import java.util.HashMap;
import java.util.Map;

public class App {
    static Map<String, RoverFact> factories = new HashMap<String, RoverFact>() {{
        put("simple", new SimpleInjection());
        put("xml", new XmlInjection());
        put("configClass", new ConfigClassInjection());
    }};

    public static void main(String[] args) {
        factories.forEach( (name, factory) -> {
            Point position = factory.buildRover()
                .moveForward()
                .turnLeft()
                .moveForward()
                .getActualPosition();

            System.out.println("'" + name + "': " + position);
        });
    }
}
