package org.launchcode.bartender_LiftOff_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "org.launchcode.bartender_LiftOff_Project")
public class BartenderLiftOffProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BartenderLiftOffProjectApplication.class, args);
	}



}
