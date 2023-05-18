package com.example.RuinAQuote;

import com.example.RuinAQuote.controllers.RuinQuoteController;
import com.example.RuinAQuote.model.Fact;
import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.services.AiScrambleService;
import com.example.RuinAQuote.services.FactService;
import com.example.RuinAQuote.services.QuoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RuinAQuoteApplicationTests {

	@Autowired
	private RuinQuoteController controller;

	@Autowired
	private AiScrambleService aiScrambleService;

	@Autowired
	private QuoteService quoteService;

	@Autowired
	private FactService factService;

	@Test
	void contextLoads() {
	}


	@Test
	public void testQuoteService_works(){

		Quote test = quoteService.getQuote();
		System.out.println(test);

		Assert.notNull(test, "API call returned nothing... ");
	}

	@Test
	public void testFactService_works(){

		Fact test = factService.getFact();
		System.out.println(test);

		Assert.notNull(test, "API call returned nothing...");
	}

	@Test
	public void smartNonsenseMethod_works(){
		//arrange...

		Quote test = controller.getNewQuote();
		System.out.println(test);
		Quote tested = controller.addNonsenseSmart(test);
		System.out.println(tested);

		Assert.notNull(tested, "Got nothing back");
	}

	@Test
	public void AiScrambleService_works(){




		Quote test = controller.getNewQuote();
		System.out.println(test);

		Quote tested = aiScrambleService.scrambleCat(test);
		System.out.println(tested);

		Assert.notNull(tested, "Not quite working...");

	}

}
