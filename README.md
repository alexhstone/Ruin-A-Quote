# Ruin-A-Quote

I made this application because I wanted to apply my knowledge of RESTful API's to something a little bit silly and fun.  
Ruin-A-Quote is a simple web service / API that communicates with three external web services to grab a random quote and manipulate that quote in surprising ways.

I used the forismatic API to get my random quotes (and their authors) 
https://forismatic.com/en/

I used the uselessfacts API to get facts (lovingly referred to by my applicaiton as "nonsense")
https://uselessfacts.jsph.pl/

and I used the openAI API to "scramble" my quotes in surprisng ways
https://openai.com/product

I will also be building a separate CLI application to make interacting with Ruin-A-Quote a little bit more intiutive. In the meantime, here's a bit of info about the routes my Web Service uses:

## ROUTES

/quote
GET 
This route will get you a random quote and it's author

quote/nonsense/front
quote/nonsense/back
quote/nonsense/smart
PUT

These routes take a quote object as a payload and return that quote with some added nonsense.  The routes describe how the nonsense will be appended.  The "smart" route uses a bit of logic to 
splice the "nonsense" into the middle of the quote as opposed to directly after or before. 

quote/jeff-my-quote/{jeffCount}
quote/jeff-my-author/first
quote/jeff-my-author/full
PUT

These routes take a quote object as a payload and insert random "Jeffs" into the quote or author.  This is a reference to my cat and to a much simpler project I did earlier into my learning called the Jeff Machine. 

quote/scramble
quote/scramble/cat
quote/scramble/programming
PUT

These routes take a quote object as a payload and send the body to the OpenAI API, accompanied by a prompt, and return the quote as it is returned by the web service.  This is particulary
fun to play with as the results can vary drastically.
