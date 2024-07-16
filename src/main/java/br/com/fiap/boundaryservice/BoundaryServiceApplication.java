package br.com.fiap.boundaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BoundaryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoundaryServiceApplication.class, args);
  }

}
