package com.example.RuinAQuote.controllers;


import com.example.RuinAQuote.dao.StoredQuoteDao;
import com.example.RuinAQuote.model.Fact;
import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.model.StoredQuote;
import com.example.RuinAQuote.services.AiScrambleService;
import com.example.RuinAQuote.services.FactService;
import com.example.RuinAQuote.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(path="/quote")
public class RuinQuoteController {

    @Autowired
    private AiScrambleService aiScrambleService;

    @Autowired
    private FactService factService;

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private StoredQuoteDao dao;


    @RequestMapping(method=RequestMethod.GET)
    public Quote getNewQuote(){
        return quoteService.getQuote();
    }

    @RequestMapping(path="/nonsense/front", method=RequestMethod.PUT)
    public Quote addNonsenseFront(@RequestBody Quote quote){
        Fact nonsense = factService.getFact();
        String newQuote = nonsense.getText() + " " + quote.getQuoteText();
        quote.setQuoteText(newQuote);
        return quote;
    }

    @RequestMapping(path="/nonsense/back", method=RequestMethod.PUT)
    public Quote addNonsenseBack(@RequestBody Quote quote){
        Fact nonsense = factService.getFact();
        String newQuote = quote.getQuoteText() + " " + quote.getQuoteText();
        return quote;
    }

    @RequestMapping(path="/nonsense/smart", method=RequestMethod.PUT)
    public Quote addNonsenseSmart(@RequestBody Quote quote){
        Fact nonsense = factService.getFact();

        //handle a quote with no periods
        if (!quote.getQuoteText().contains(".")){
            String noPeriodQuote = quote.getQuoteText() + ", " + nonsense.getText();
            quote.setQuoteText(noPeriodQuote);
            return quote;
        }


        //handle really short quotes
        if (quote.getQuoteText().length() < 3){
            String shortQuote = quote.getQuoteText().substring(0, quote.getQuoteText().length() - 1) + ", " + nonsense.getText();
            quote.setQuoteText(shortQuote);
            return quote;
        }

        //if we have a comma, let's use it to our advantage.
        if (quote.getQuoteText().contains(",")) {
            //make our fact a little comma'd interjection...
            String randomCommaNonsense = ", " + nonsense.getText().trim().substring(0, nonsense.getText().length() - 1) + ",";

            //find the comma...
            int indexOfComma = quote.getQuoteText().indexOf(",");

            //split the string...
            String toComma = quote.getQuoteText().substring(0, indexOfComma);
            String afterComma = quote.getQuoteText().substring(indexOfComma + 1);

            //insert nonsense...
            String newCommaQuote = toComma + randomCommaNonsense + afterComma;

            //return nonsense...
            quote.setQuoteText(newCommaQuote);
            return quote;

            }

            String fallbackNonsense = nonsense.getText().substring(0, nonsense.getText().length() - 1) + ", " + quote.getQuoteText();
            quote.setQuoteText(fallbackNonsense);
            return quote;

        }

    @RequestMapping(path="/jeff-my-quote/{jeffCount}", method=RequestMethod.PUT)
    public Quote jeffMyQuote(@RequestBody Quote quote, @PathVariable int jeffCount){

        String[]words = quote.getQuoteText().split(" ");
        Random random = new Random();

        for (int i = 0; i < jeffCount; i++){
            int index = random.nextInt(words.length);
            words[index] = "Jeff";
        }

        quote.setQuoteText(String.join(" ", words));
        return quote;

        }

    @RequestMapping(path="/jeff-my-author/first", method=RequestMethod.PUT)
    public Quote jeffMyAuthorFirstName (@RequestBody Quote quote){

        String[]names = quote.getQuoteAuthor().split(" ");
        names[0] = "Jeff";

        //handle one word names
        if (names.length < 2){
            quote.setQuoteAuthor(names[0]);
            return quote;
        }

        quote.setQuoteAuthor(String.join(" ", names));
        return quote;
    }

    @RequestMapping(path="/jeff-my-author/full", method=RequestMethod.PUT)
    public Quote jeffMyAuthorFullName (@RequestBody Quote quote){
        String[]addOns = {"er", "in", "son", "ster"};
        String[]names = quote.getQuoteAuthor().split(" ");
        Random random = new Random();

        //first name is always Jeff...
        names[0] = "Jeff";

        //handle one word names
        if (names.length < 2){
            quote.setQuoteAuthor(names[0]);
            return quote;
        }

        //Last name or middle name(s) can be different though!
        for (int i = 1; i < names.length; i++){
           names[i] = "Jeff" + addOns[random.nextInt(addOns.length)];
        }

        quote.setQuoteAuthor(String.join(" ", names));

        return quote;
    }

    @RequestMapping(path="/scramble", method=RequestMethod.PUT)
    public Quote scramble(@RequestBody Quote quote){
        return aiScrambleService.scrambleStrange(quote);
    }

    @RequestMapping(path="/scramble/cat", method=RequestMethod.PUT)
    public Quote scrambleCat(@RequestBody Quote quote){
        return aiScrambleService.scrambleCat(quote);
    }

    @RequestMapping(path="/scramble/programming", method=RequestMethod.PUT)
    public Quote scrambleProgramming(@RequestBody Quote quote){
        return aiScrambleService.scrambleProgramming(quote);
    }


    //To Do:
    //This is left over from the built-in CLI. come back and rework this once
    //The CLI is reimplemented as a standalone program. 


    //@RequestMapping(path="/save")
//    public void saveQuote(Quote original, Quote mod){
//        dao.add(original, mod);
//    }
//
//    public List<StoredQuote>listStoredQuotes(){
//        return dao.list();
//    }

    }




