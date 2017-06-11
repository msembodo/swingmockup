package net.msembodo.swingmockup;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import net.msembodo.swingmockup.controller.AddController;
import net.msembodo.swingmockup.model.Model;
import net.msembodo.swingmockup.view.View;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private View view;

	@Override
	public void run(String... arg0) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				view.init();
			}
		});
	}
	
	@Bean
	public View view() {
		return new View();
	}
	
	@Bean
	public Model model() {
		return new Model();
	}
	
	@Bean 
	public AddController addController() {
		return new AddController();
	}

}
