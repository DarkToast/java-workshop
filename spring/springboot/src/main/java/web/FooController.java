package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class FooController {

    @Autowired
    ProjectRepo repo;

    @RequestMapping(path = "/foo", method = RequestMethod.GET)
    public ResponseEntity<Project> project() {
        return ResponseEntity.ok(new Project("123", "HelloProject"));
    }

    @RequestMapping(path = "/foo", method = RequestMethod.POST)
    public ResponseEntity<Project> project(@RequestBody Project project) {
        repo.save(project);
        return ResponseEntity.ok(project);
    }
}
