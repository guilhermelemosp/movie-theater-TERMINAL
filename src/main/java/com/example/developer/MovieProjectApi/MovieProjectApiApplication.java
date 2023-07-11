package com.example.developer.MovieProjectApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.CLI", "com.example.developer.MovieProjectApi"})
public class MovieProjectApiApplication {
	@Autowired
	// private StructureCLI structureCLI;


	public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(MovieProjectApiApplication.class, args);
    StructureCLI structureCLI = context.getBean(StructureCLI.class);
    structureCLI.run();
}


}
