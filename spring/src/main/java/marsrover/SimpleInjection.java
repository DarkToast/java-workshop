package marsrover;

import marsrover.rover.FastRover;
import marsrover.rover.Rover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;

public class SimpleInjection implements RoverFact {
    @Override
    public Rover buildRover() {
        return new FastRover(new FlatWorld());
    }
}
