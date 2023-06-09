package com.RuinAQuoteCLI.Ruin.A.Quote.CLI.model;

public class Quote {

        private String quoteText;
        private String quoteAuthor;


        public Quote() {
        }

        public Quote(String quoteText, String quoteAuthor) {
            this.quoteText = quoteText;
            this.quoteAuthor = quoteAuthor;
        }

        public String getQuoteText() {
            return quoteText;
        }

        public void setQuoteText(String quoteText) {
            this.quoteText = quoteText;
        }

        public String getQuoteAuthor() {
            return quoteAuthor;
        }

        public void setQuoteAuthor(String quoteAuthor) {
            this.quoteAuthor = quoteAuthor;
        }

        @Override
        public String toString(){
            if (quoteAuthor == null || quoteAuthor.isBlank()){
                quoteAuthor = "Jeff";
            }

            return String.format("%s - %s", quoteText, quoteAuthor);

        }

    }
