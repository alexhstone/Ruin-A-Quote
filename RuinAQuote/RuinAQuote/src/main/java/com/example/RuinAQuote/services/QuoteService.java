package com.example.RuinAQuote.services;

import com.example.RuinAQuote.model.Quote;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteService {

    private final String API_BASE_URL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

    RestTemplate restTemplate = new RestTemplate();

    public Quote getQuote(){

        try {
            return restTemplate.getForObject(API_BASE_URL, Quote.class);
        } catch (Exception e){
            System.out.println("Uh oh, something went wrong... it was this: " + e.getMessage());
        }
        return null;
    }

}
