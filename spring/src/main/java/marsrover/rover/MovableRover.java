package marsrover.rover;

abstract public class MovableRover implements Rover {

    private Direction direction = Direction.NORTH;

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public Rover turnLeft() {
        switch(direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
        }

        return this;
    }

    @Override
    public Rover turnRight() {
        switch(direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
        }

        return this;
    }
}
