package tn.esprit.sae7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class Sae7Application {

    public static void main(String[] args) {
        SpringApplication.run(Sae7Application.class, args);
    }

}
