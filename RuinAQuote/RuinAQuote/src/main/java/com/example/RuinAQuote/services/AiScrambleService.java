package com.example.RuinAQuote.services;

import com.example.RuinAQuote.model.AiScrambleDto;
import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.model.ScrambledText;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@PropertySource("classpath:/application.properties")
public class AiScrambleService {

    private final String BASE_API_URL = "https://api.openai.com/v1/edits";
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${openai.api.key}")
    private String secretKey;

    private final String BASE = "paraphrase this in a strange way";
    private final String CAT = "change the input quote to make it about cats but keep the meaning similar";
    private final String PROGRAMMING = "change the input quote to make it about programming but keep the meaning similar";


    public AiScrambleService() {
    }


    public Quote scramble(Quote quote, String modifier) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(secretKey);
        HttpEntity<AiScrambleDto> entity = new HttpEntity<>(new AiScrambleDto(quote.getQuoteText(), modifier), headers);
        try {
            ScrambledText scrambled = restTemplate.postForObject(BASE_API_URL, entity, ScrambledText.class);
            quote.setQuoteText(scrambled.toString());
            return quote;
        } catch (Exception e) {
            System.out.println("Uh oh!  Something went wrong!  It was this:  " + e.getMessage());
        }
        return null;
    }

    public Quote scrambleCat(Quote quote){
        return scramble(quote, CAT);
    }

    public Quote scrambleStrange(Quote quote){
        return scramble(quote, BASE);
    }

    public Quote scrambleProgramming(Quote quote){
        return scramble(quote, PROGRAMMING);
    }

}