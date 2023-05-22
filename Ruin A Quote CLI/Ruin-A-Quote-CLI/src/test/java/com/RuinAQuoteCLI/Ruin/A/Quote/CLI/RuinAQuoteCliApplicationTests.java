package com.RuinAQuoteCLI.Ruin.A.Quote.CLI;

import com.RuinAQuoteCLI.Ruin.A.Quote.CLI.model.Quote;
import com.RuinAQuoteCLI.Ruin.A.Quote.CLI.services.RuinQuoteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RuinAQuoteCliApplicationTests {

	private RuinQuoteService sut = new RuinQuoteService();

	@Test
	void contextLoads() {
	}

	@Test
	public void test_GetNewQuote_gets_quote(){

		Quote actual = sut.getNewQuote();

		System.out.println(actual);

		Assert.notNull(actual, "ope");
	}

	@Test
	public void test_addNonSenseFront_adds_nonsense_to_the_front(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.addNonsenseFront(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_addNonsenseBack_adds_nonsense_to_the_back(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.addNonsenseBack(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_addNonsenseSmart_adds_nonsense_smartly(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.addNonsenseSmart(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_jeffMyQuote_jeffs_quote(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.jeffMyQuote(original, 3);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_jeffMyAuthorFirstName_jeffs_author_good(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.jeffMyAuthorFirstName(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");
	}

	@Test
	public void test_jeffMyAuthorFull_jeffs_authors_fullName(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.jeffMyAuthorFull(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_scramble_scrambles(){


		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.scramble(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_scrambleCat_scrambles_catly(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.scrambleCat(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

	@Test
	public void test_scrambleProgramming_scrambles_programmatically(){

		Quote original = sut.getNewQuote();

		System.out.println(original);

		Quote mod = sut.scrambleProgramming(original);

		System.out.println(mod);

		Assert.notNull(mod, "ope");

	}

}
