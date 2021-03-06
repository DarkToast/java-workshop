package marsrover.rover

import marsrover.world.FlatWorld
import spock.lang.Specification
import spock.lang.Subject

import static marsrover.rover.Direction.*

class SlowRoverSpec extends Specification {

    @Subject
    def rover = {
        def rover = new SlowRover()
        rover.setWorld(new FlatWorld())
        return rover
    }()

    def "A fast rover stands north after landing"() {
        expect: "The rovers direction is north"
        rover.getDirection() == NORTH
    }

    def "Turn the rover left, moves it to west"() {
        when: "we turn the rover left"
        rover.turnLeft()

        then: "The rovers direction is west"
        rover.getDirection() == WEST
    }

    def "Turn the rover right, moves it to east"() {
        when: "we turn the rover right"
        rover.turnRight()

        then: "The rovers direction is eaast"
        rover.getDirection() == EAST
    }

    def "Turn the rover right twice, moves it to south"() {
        when: "we turn the rover right"
        rover.turnRight().turnRight()

        then: "The rovers direction is south"
        rover.getDirection() == SOUTH
    }

    def "Turn the rover left twice, moves it to south"() {
        when: "we turn the rover left"
        rover.turnLeft().turnLeft()

        then: "The rovers direction is south"
        rover.getDirection() == SOUTH
    }

    def "Turn the rover left four times and is back to north"() {
        when: "we turn the rover left"
        rover.turnLeft().turnLeft().turnLeft().turnLeft()

        then: "The rovers directs back to north"
        rover.getDirection() == NORTH
    }

    def "Move the rover forward increments the position by two steps"() {
        given: "The actual position"
        def position = rover.getActualPosition()

        when: "we move the rover forward"
        rover.moveForward()

        then: "The position is two steps north of the old position"
        rover.getActualPosition().x == position.x
        rover.getActualPosition().y == position.y + 1
    }

    def "Move the rover backward decrements the position by two steps"() {
        given: "The actual position"
        def position = rover.getActualPosition()

        when: "we move the rover backward"
        rover.moveBackward()

        then: "The position is two steps south of the old position"
        rover.getActualPosition().x == position.x
        rover.getActualPosition().y == position.y - 1
    }

}
