package com.example.RuinAQuote.view;

import com.example.RuinAQuote.controllers.RuinQuoteController;
import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.model.StoredQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


public class CLI {


    private RuinQuoteController ruinQuoteController = new RuinQuoteController();
    private Scanner scanner = new Scanner(System.in);


    public void run(){
        displayBanner();
        about();
        Quote original = null;
        Quote mod = null;

        while(true){
            if (original == null){
                System.out.println("Here's a quote to get you started!");
                original = ruinQuoteController.getNewQuote();
            }
            System.out.println("Original Quote:");
            System.out.println(original);
            if (mod != null){
                System.out.println("Ruined Quote:");
                System.out.println(mod);
            }
            displayMenu();
            int userInput = promptForInt();
            if (userInput == 1){
               original = ruinQuoteController.getNewQuote();
               mod = null;
            }
            if (userInput == 2){
                //if user hasn't done any mods yet, we set it to a clone of the original quote
                if (mod == null){
                    mod = new Quote(original.getQuoteText(), original.getQuoteAuthor());
                }
                mod = addNonsense(mod);
            }
            if (userInput == 3){
                if (mod == null){
                    mod = new Quote(original.getQuoteText(), original.getQuoteAuthor());
                }
                mod = handleScrambleIt(mod);
            }
            if (userInput == 4){
                if (mod == null){
                    mod = new Quote(original.getQuoteText(), original.getQuoteAuthor());
                }
                mod = handleJeffIt(mod);
            }
            if (userInput == 5){
                if (original != null && mod != null) {
                    ruinQuoteController.saveQuote(original, mod);
                    continue;
                } else System.out.println("You gotta do something to the quote first!");
            }
            if (userInput == 6){

                displayQuotes(ruinQuoteController.listStoredQuotes());
            }
            if (userInput == 7){
                break;
            }

        }
    }



    private void displayBanner() {
        System.out.println("-----------------------------------------");
        System.out.println("|             Let's Ruin It!            |");
        System.out.println("-----------------------------------------");
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("1. Get a new Quote");
        System.out.println("2. Add some nonsense");
        System.out.println("3. Scramble it!");
        System.out.println("4. Jeff it!");
        System.out.println("5. Save current quote/mod");
        System.out.println("6. Display saved quotes");
        System.out.println("7. Exit");
    }

    private void about(){
        System.out.println("Let's Ruin It\u2122 is a brand new exciting and interactive quote ruining experience from the creator of the Jeff Machine.");
    }

    private void displayNonsenseOptions(){
        System.out.println();
        System.out.println("1. Add nonsense to the front of my quote.");
        System.out.println("2. Add nonsense to the back of my quote.");
        System.out.println("3. Use the Smart Nonsense\u2122 tool to add nonsense.");
        System.out.println();
    }

    private Quote addNonsense(Quote quote){
        Quote mod = null;
        System.out.println("How would you like your nonsense?");
        displayNonsenseOptions();
        while(true){
            int userInput = promptForInt();
            if (userInput == 1){
                mod = ruinQuoteController.addNonsenseFront(quote);
                return mod;
            }
            if (userInput == 2){
                mod = ruinQuoteController.addNonsenseBack(quote);
                return mod;
            }
            if (userInput == 3){
                mod = ruinQuoteController.addNonsenseSmart(quote);
                return mod;
            }
        }
    }

    private Quote handleJeffIt(Quote quote){
        Quote mod = null;
        displayJeffItOptions();
        while (true) {
            int userInput = promptForInt();
            if (userInput == 1){
                mod = jeffMyQuote(quote);
                return mod;
            }
            if (userInput == 2){
                mod = jeffMyAuthor(quote);
                return mod;
            }
            if (userInput == 3){
                mod = jeffMyQuote(quote);
                mod = jeffMyAuthor(mod);
                return mod;
            }
        }
    }

    private void displayJeffItOptions(){
        System.out.println();
        System.out.println("1. Jeff my quote!");
        System.out.println("2. Jeff my author!");
        System.out.println("3. Jeff both!");
        System.out.println();
    }

    private Quote jeffMyQuote(Quote quote){
        System.out.println("How Jeff'd do you want your quote? (enter a number)");
        int jeffCount = promptForInt();
        return ruinQuoteController.jeffMyQuote(quote, jeffCount);
    }

    private Quote jeffMyAuthor(Quote quote) {
        System.out.println("How Jeff'd do you want your author's name?");
        System.out.println("1. Just the first name, please.");
        System.out.println("2. Jeff my stuff up.");
        while (true) {
            int userChoice = promptForInt();

            if (userChoice == 1) {
                quote = ruinQuoteController.jeffMyAuthorFirstName(quote);
                return quote;
            }
            if (userChoice == 2) {
                quote = ruinQuoteController.jeffMyAuthorFullName(quote);
                return quote;
            }

        }
    }

    private Quote handleScrambleIt(Quote quote){
        System.out.println("Scramble It\u2122 is powered by ChatGPT");
        return ruinQuoteController.scramble(quote);
    }

    private void displayQuotes(List<StoredQuote> quotes){
        System.out.println("-----------------------------------------");
        System.out.println("            Saved quotes                 ");
        System.out.println("-----------------------------------------");
        if (quotes.size() < 1){
            System.out.println("No quotes to show :(");
            System.out.println("Try saving one!");
        }
        for (StoredQuote quote : quotes){
            System.out.println(quote.toString());
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }



    private int promptForInt(){
        while (true) {
            String response = scanner.nextLine();
            try {
                return Integer.parseInt(response);
            } catch (NumberFormatException e) {
                if (response.isBlank()) {
                    return -1; //Assumes negative numbers are never valid entries.
                } else {
                    System.out.println("Numbers only, please.");
                }
            }
        }
    }

}
