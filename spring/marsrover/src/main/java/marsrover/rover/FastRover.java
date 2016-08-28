package marsrover.rover;

import marsrover.world.Point;
import marsrover.world.World;

public class FastRover extends MovableRover {

    private final World world;
    private Point position;

    public FastRover(World world) {
        this.world = world;
        this.position = world.land();
    }

    @Override
    public Rover moveForward() {
        switch(getDirection()) {
            case NORTH:
                position = world.toNorth(world.toNorth(position));
                break;
            case WEST:
                position = world.toWest(world.toWest(position));
                break;
            case SOUTH:
                position = world.toSouth(world.toSouth(position));
                break;
            case EAST:
                position = world.toEast(world.toEast(position));
        }

        return this;
    }

    @Override
    public Rover moveBackward() {
        switch(getDirection()) {
            case NORTH:
                position = world.toSouth(world.toSouth(position));
                break;
            case WEST:
                position = world.toEast(world.toEast(position));
                break;
            case SOUTH:
                position = world.toNorth(world.toNorth(position));
                break;
            case EAST:
                position = world.toWest(world.toWest(position));
        }

        return this;
    }

    @Override
    public Point getActualPosition() {
        return position;
    }
}
