package com.example.RuinAQuote.dao;

import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.model.StoredQuote;

import java.util.List;

public interface StoredQuoteDao {

    //return a list of all stored quotes...
    List<StoredQuote> list();

    //add a stored quote to storage...
    void add(Quote original, Quote mod);

}
