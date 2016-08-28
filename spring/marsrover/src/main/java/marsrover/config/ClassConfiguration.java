package marsrover.config;

import marsrover.rover.Rover;
import marsrover.rover.SlowRover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;
import marsrover.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ClassConfiguration implements RoverConfig {
    @Override
    public Rover buildRover() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(RoverConfig.class);
        applicationContext.refresh();

        return applicationContext.getBean("rover", Rover.class);
    }

    @Configuration
    static class RoverConfig {
        @Bean(name = "flatWorld")
        World flatWorld() {
            return new FlatWorld();
        }

        @Bean(name = "globeWorld")
        World globeWorld() {
            return new GlobeWorld();
        }

        @Bean(name = "rover")
        Rover rover(@Autowired @Qualifier("globeWorld") World world) {
            return new SlowRover(world);
        }
    }
}
