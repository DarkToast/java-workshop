package marsrover.rover;

import marsrover.world.Point;
import marsrover.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AutoConfigRover extends TurnableRover {

    private World world;
    private int gear;
    private Point position;

    @Autowired
    public AutoConfigRover(@Qualifier("globeWorld") final World world) {
        this.world = world;
        this.position = world.land();
    }

    @Autowired
    @Value("${rover.gear}")
    public void setGear(int gear) {
        this.gear = gear;
    }

    @Override
    public Rover moveForward() {
        Function<Point, Point> moveOrder;

        switch(getDirection()) {
            case NORTH:
                moveOrder = (start1) -> world.toNorth(start1);
                break;
            case WEST:
                moveOrder = (start) -> world.toWest(start);
                break;
            case SOUTH:
                moveOrder = (start) -> world.toSouth(start);
                break;
            case EAST:
            default:
                moveOrder = (start) -> world.toEast(start);
        }

        for(int i = 0; i < gear; i++) {
            position = moveOrder.apply(position);
        }

        return this;
    }

    @Override
    public Rover moveBackward() {
        Function<Point, Point> moveOrder;

        switch(getDirection()) {
            case NORTH:
                moveOrder = (start) -> world.toSouth(start);
                break;
            case WEST:
                moveOrder = (start) -> world.toEast(start);
                break;
            case SOUTH:
                moveOrder = (start) -> world.toNorth(start);
                break;
            case EAST:
            default:
                moveOrder = (start) -> world.toWest(start);
        }

        for(int i = 0; i < gear; i++) {
            position = moveOrder.apply(position);
        }

        return this;
    }

    @Override
    public Point getActualPosition() {
        return position;
    }
}
