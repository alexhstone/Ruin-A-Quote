# Ruin-A-Quote

I made this application because I wanted to apply my knowledge of RESTful API's to something a little bit silly and fun.  
Ruin-A-Quote is a simple web service / API that communicates with three external web services to grab a random quote and manipulate that quote in surprising ways.

I used the forismatic API to get my random quotes (and their authors) 
https://forismatic.com/en/

I used the uselessfacts API to get facts (lovingly referred to by my applicaiton as "nonsense")
https://uselessfacts.jsph.pl/

and I used the openAI API to "scramble" my quotes in surprisng ways
https://openai.com/product

##SET UP

I've also included a simple CLI as a separate project so that you can interact with the Ruin-A-Quote API in a more direct way.  Getting it up and running should be pretty simple.  You'll just need to pull the project and add / configure on file in each project. 

### SERVER SET UP
In the RuinAQuote project, you'll need to create an applications.properties file in a directory called resources (`src/main/resources/application.properties`).  Next, you'll need to create a free account on openai and get an API key.  Put that key in your application.properties file like this: `openai.api.key=<YOUR KEY HERE>`

### CLI SET UP
In the RuinAQuoteCLI project, you'll need to configure your project to use a different port than the server.  If you know how to do this, you can skip my instructions.  If not, do this: repeat the steps above to create an application.propreties file. Add this line to that file: `server.port=0` <br /> 
That's it! Enjoy!


## ROUTES

` GET ` <br />
` /quote ` <br />

This route will get you a random quote and it's author

` PUT ` <br />
` quote/nonsense/front ` <br />
` quote/nonsense/back ` <br />
` quote/nonsense/smart ` <br />


These routes take a quote object as a payload and return that quote with some added nonsense.  The routes describe how the nonsense will be appended.  The "smart" route uses a bit of logic to 
splice the "nonsense" into the middle of the quote as opposed to directly after or before. 

` PUT ` <br />
` quote/jeff-my-quote/{jeffCount} ` <br />
` quote/jeff-my-author/first ` <br />
` quote/jeff-my-author/full ` <br />


These routes take a quote object as a payload and insert random "Jeffs" into the quote or author.  This is a reference to my cat and to a much simpler project I did earlier into my learning called the Jeff Machine. 

`PUT ` <br />
` quote/scramble ` <br />
` quote/scramble/cat ` <br />
` quote/scramble/programming ` <br />


These routes take a quote object as a payload and send the body to the OpenAI API, accompanied by a prompt, and return the quote as it is returned by the web service.  This is particulary
fun to play with as the results can vary drastically.
