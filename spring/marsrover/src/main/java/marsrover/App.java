package marsrover;

import marsrover.config.ClassConfiguration;
import marsrover.config.RoverConfig;
import marsrover.config.SimpleConfiguration;
import marsrover.config.XmlConfiguration;
import marsrover.rover.Rover;

import java.util.HashMap;
import java.util.Map;

public class App {
    static Map<String, RoverConfig> factories = new HashMap<String, RoverConfig>() {{
        put("simple", new SimpleConfiguration());
        put("xml", new XmlConfiguration());
        put("configClass", new ClassConfiguration());
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
