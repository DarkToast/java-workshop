package marsrover.controller;

import marsrover.rover.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoverController {

    @Autowired
    @Qualifier("autoConfigRover")
    Rover rover;

    @RequestMapping(path = "/rover", method = RequestMethod.GET)
    public ResponseEntity<String> rover() {
        final String position = rover.getActualPosition().toString();
        final String direction = rover.getDirection().toString();
        return ResponseEntity.ok(direction + " | " +position);
    }

    @RequestMapping(path = "/rover/position", method = RequestMethod.GET)
    public ResponseEntity<String> position() {
        return ResponseEntity.ok(rover.getActualPosition().toString());
    }

    @RequestMapping(path = "/rover/direction", method = RequestMethod.GET)
    public ResponseEntity<String> direction() {
        return ResponseEntity.ok(rover.getDirection().toString());
    }

    @RequestMapping(path = "/rover", method = RequestMethod.PUT)
    public ResponseEntity<String> command(@RequestBody String command) {
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'F':
                case 'f':
                    rover.moveForward();
                    break;
                case 'B':
                case 'b':
                    rover.moveBackward();
                    break;
                case 'L':
                case 'l':
                    rover.turnLeft();
                    break;
                case 'R':
                case 'r':
                    rover.turnRight();
            }
        }

        return rover();
    }
}
