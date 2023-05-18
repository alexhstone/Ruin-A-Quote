package com.example.RuinAQuote.services;

import com.example.RuinAQuote.model.Fact;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FactService {

    private final String BASE_API_URL = "https://uselessfacts.jsph.pl/api/v2/facts/random";

    private RestTemplate restTemplate = new RestTemplate();


    public Fact getFact(){
        try {
            return restTemplate.getForObject(BASE_API_URL, Fact.class);
        } catch (Exception e){
            System.out.println("Uh oh!  Something went wrong... it was this: " + e.getMessage());
        }
        return null;
    }


}
