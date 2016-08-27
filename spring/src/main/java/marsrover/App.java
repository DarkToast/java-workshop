package marsrover;

import marsrover.rover.Rover;

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
            Rover rover = factory.buildRover()
                .moveForward()
                .turnLeft()
                .moveForward();

            System.out.println("'" + name + "' - Coord: " + rover.getActualPosition() + ", Direction: " + rover.getDirection());
        });
    }
}
