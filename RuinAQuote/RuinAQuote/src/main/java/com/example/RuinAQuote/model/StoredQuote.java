package com.example.RuinAQuote.model;

public class StoredQuote {

    private String originalQuote;
    private String modQuote;
    private String originalAuthor;
    private String modAuthor;

    public StoredQuote() {
    }

    public StoredQuote(Quote original, Quote mod) {
        this.originalQuote = original.getQuoteText();
        this.originalAuthor = original.getQuoteAuthor();
        this.modQuote = mod.getQuoteText();
        this.modAuthor = mod.getQuoteAuthor();
    }


    @Override
    public String toString(){
        return originalQuote + " - " + originalAuthor + "\n" + modQuote + " - " + modAuthor;
    }

}
