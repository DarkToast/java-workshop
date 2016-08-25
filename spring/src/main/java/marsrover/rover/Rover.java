package marsrover.rover;

import marsrover.world.Point;

public interface Rover {
    Rover moveForward();

    Rover moveBackward();

    Rover turnLeft();

    Rover turnRight();

    Point getActualPosition();
}
