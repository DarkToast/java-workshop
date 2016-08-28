package marsrover.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoverController {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("foobar");
    }
}
