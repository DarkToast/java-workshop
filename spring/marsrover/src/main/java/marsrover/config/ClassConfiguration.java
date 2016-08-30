package marsrover.config;

import marsrover.rover.Rover;
import marsrover.rover.SlowRover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;
import marsrover.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

public class ClassConfiguration implements RoverConfig {
    @Override
    public Rover buildRover() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(RoverConfig.class);
        applicationContext.scan("marsrover.rover");
        applicationContext.refresh();

        return applicationContext.getBean("autoConfigRover", Rover.class);
    }

    @Configuration
    @PropertySource("classpath:/rover.properties")
    static class RoverConfig {

        @Value("${rover.gear}")
        int gear;

        @Bean(name = "flatWorld")
        World flatWorld() {
            return new FlatWorld();
        }

        @Bean(name = "globeWorld")
        World globeWorld() {
            return new GlobeWorld();
        }

        @Bean(name = "rover")
        @Autowired
        Rover rover(@Qualifier("globeWorld") World world) {
            SlowRover rover = new SlowRover();
            rover.setWorld(world);

            return rover;
        }
    }
}
