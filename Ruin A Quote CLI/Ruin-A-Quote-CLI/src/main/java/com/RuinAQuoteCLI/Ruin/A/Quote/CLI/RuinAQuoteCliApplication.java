package com.RuinAQuoteCLI.Ruin.A.Quote.CLI;

import com.RuinAQuoteCLI.Ruin.A.Quote.CLI.view.CLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuinAQuoteCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuinAQuoteCliApplication.class, args);
		CLI app = new CLI();
		app.run();
	}

}
