package br.com.prodam.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodam.configuration.GreetingConfiguration;
import br.com.prodam.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final GreetingConfiguration configuration;	

	public GreetingController(GreetingConfiguration configuration) {
		this.configuration = configuration;
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.isEmpty())
			name = configuration.getDefaultValue();
		return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
	}
}
