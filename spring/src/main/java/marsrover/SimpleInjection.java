package marsrover;

import marsrover.rover.FastRover;
import marsrover.rover.Rover;
import marsrover.rover.SlowRover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;

public class SimpleInjection {

    public static void main(String[] args) {
        System.out.println(
            new SimpleInjection().buildRover()
                .moveForward()
                .turnLeft()
                .moveForward()
                .getActualPosition().toString()
        );
    }

    public Rover buildRover() {
        return new FastRover(new GlobeWorld());
    }
}
