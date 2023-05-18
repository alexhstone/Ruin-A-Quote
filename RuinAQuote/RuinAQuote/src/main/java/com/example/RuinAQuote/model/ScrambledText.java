package com.example.RuinAQuote.model;

public class ScrambledText {
    private Object[]choices;

    //this class is really just kind of, let's get this working... doesn't have to be pretty.

    public ScrambledText() {
    }

    public ScrambledText(Object[] choices) {
        this.choices = choices;
    }

    public Object[] getChoices() {
        return choices;
    }

    public void setChoices(Object[] choices) {
        this.choices = choices;
    }

    //to-do, do this in a less stupid way.
    @Override
    public String toString() {
        return choices[0].toString().substring(6, choices[0].toString().length() - 10);
    }
}
