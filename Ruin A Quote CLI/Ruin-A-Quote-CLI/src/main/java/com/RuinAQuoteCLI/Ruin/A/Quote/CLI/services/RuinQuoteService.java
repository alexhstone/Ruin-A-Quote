package com.RuinAQuoteCLI.Ruin.A.Quote.CLI.services;

import com.RuinAQuoteCLI.Ruin.A.Quote.CLI.model.Quote;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RuinQuoteService {

    private final String BASE_API_URL = "http://localhost:8080/quote";

    private RestTemplate restTemplate = new RestTemplate();

    //get a fresh quote...
    public Quote getNewQuote(){

        try {
            return restTemplate.getForObject(BASE_API_URL, Quote.class);
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong... it was this: " + e.getMessage());
        }
        return null;

    }

    //add nonsense routes (3 total)
    public Quote addNonsenseFront(Quote quote){
        Quote updatedQuote = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

        try{
            ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/nonsense/front", HttpMethod.PUT, entity, Quote.class);
            updatedQuote = response.getBody();
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
        }

        return updatedQuote;
    }

    public Quote addNonsenseBack(Quote quote){
        Quote updatedQuote = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

        try{
            ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/nonsense/back", HttpMethod.PUT, entity, Quote.class);
            updatedQuote = response.getBody();
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
        }

        return updatedQuote;
    }

    public Quote addNonsenseSmart(Quote quote){
        Quote updatedQuote = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

        try{
            ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/nonsense/smart", HttpMethod.PUT, entity, Quote.class);
            updatedQuote = response.getBody();
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
        }

        return updatedQuote;
    }

    public Quote jeffMyQuote(Quote quote, int count){
        Quote updatedQuote = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

        try{
            ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/jeff-my-quote/" + count, HttpMethod.PUT, entity, Quote.class);
            updatedQuote = response.getBody();
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
        }

        return updatedQuote;

    }

public Quote jeffMyAuthorFirstName(Quote quote){

    Quote updatedQuote = null;
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

    try{
        ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/jeff-my-author/first", HttpMethod.PUT, entity, Quote.class);
        updatedQuote = response.getBody();
    } catch (Exception e){
        System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
    }

    return updatedQuote;
}

public Quote jeffMyAuthorFull(Quote quote){

    Quote updatedQuote = null;
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

    try{
        ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/jeff-my-author/full", HttpMethod.PUT, entity, Quote.class);
        updatedQuote = response.getBody();
    } catch (Exception e){
        System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
    }

    return updatedQuote;
}

public Quote scramble(Quote quote){
    Quote updatedQuote = null;
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

    try{
        ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/scramble", HttpMethod.PUT, entity, Quote.class);
        updatedQuote = response.getBody();
    } catch (Exception e){
        System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
    }

    return updatedQuote;
}

public Quote scrambleCat(Quote quote){
    Quote updatedQuote = null;
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

    try{
        ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/scramble/cat", HttpMethod.PUT, entity, Quote.class);
        updatedQuote = response.getBody();
    } catch (Exception e){
        System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
    }

    return updatedQuote;

}

public Quote scrambleProgramming(Quote quote){
    Quote updatedQuote = null;
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Quote> entity = new HttpEntity<>(quote, headers);

    try{
        ResponseEntity<Quote> response =  restTemplate.exchange(BASE_API_URL + "/scramble/programming", HttpMethod.PUT, entity, Quote.class);
        updatedQuote = response.getBody();
    } catch (Exception e){
        System.out.println("Uh oh, something went wrong! it was this: " + e.getMessage());
    }

    return updatedQuote;
}


}
