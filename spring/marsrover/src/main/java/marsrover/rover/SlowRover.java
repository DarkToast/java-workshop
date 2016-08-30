package marsrover.rover;

import marsrover.world.Point;
import marsrover.world.World;

public class SlowRover extends TurnableRover {

    private World world;
    private Point position;

    public SlowRover() {
    }

    public void setWorld(World world) {
        this.world = world;
        this.position = world.land();
    }

    @Override
    public Rover moveForward() {
        switch(getDirection()) {
            case NORTH:
                position = world.toNorth(position);
                break;
            case WEST:
                position = world.toWest(position);
                break;
            case SOUTH:
                position = world.toSouth(position);
                break;
            case EAST:
                position = world.toEast(position);
        }

        return this;
    }

    @Override
    public Rover moveBackward() {
        switch(getDirection()) {
            case NORTH:
                position = world.toSouth(position);
                break;
            case WEST:
                position = world.toEast(position);
                break;
            case SOUTH:
                position = world.toNorth(position);
                break;
            case EAST:
                position = world.toWest(position);
        }

        return this;
    }

    @Override
    public Point getActualPosition() {
        return position;
    }
}
