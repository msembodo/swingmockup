package net.msembodo.swingmockup;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SwingmockupApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SwingmockupApplication.class)
			.headless(false)
			.web(false)
			.run(args);
	}
	
}
