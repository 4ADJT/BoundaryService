package br.com.fiap.boundaryservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})

@SpringBootApplication
@EnableMongoAuditing
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class BoundaryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BoundaryServiceApplication.class, args);
  }

}
