package marsrover.config;

import marsrover.rover.FastRover;
import marsrover.rover.Rover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;

public class SimpleConfiguration implements RoverConfig {
    @Override
    public Rover buildRover() {
        return new FastRover(new GlobeWorld());
    }
}
