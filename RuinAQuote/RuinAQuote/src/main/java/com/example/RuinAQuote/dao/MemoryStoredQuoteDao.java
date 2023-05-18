package com.example.RuinAQuote.dao;

import com.example.RuinAQuote.model.Quote;
import com.example.RuinAQuote.model.StoredQuote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStoredQuoteDao implements StoredQuoteDao{

    private final List<StoredQuote> saved = new ArrayList<>();

    public MemoryStoredQuoteDao() {
    }

    @Override
    public List<StoredQuote> list() {
        return saved;
    }

    @Override
    public void add(Quote original, Quote mod) {
        saved.add(new StoredQuote(original, mod));

    }
}
