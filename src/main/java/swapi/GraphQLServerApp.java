package swapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "swapi")
public class GraphQLServerApp  {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLServerApp.class, args);
    }

}
