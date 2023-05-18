package com.example.RuinAQuote.model;

public class Fact {

    private String text;


    public Fact(){

    }

    public Fact(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

}
