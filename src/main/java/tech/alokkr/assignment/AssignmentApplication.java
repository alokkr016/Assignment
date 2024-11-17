package tech.alokkr.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude = {
//		org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
//})
@SpringBootApplication
@ComponentScan(basePackages = "tech.alokkr.assignment")
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
}
