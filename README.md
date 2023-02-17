# Mini-quote

A simple web-application using Spring framework and an in-memory database that enables you to create users, post quotes and vote for them. 

## Launch

Use the docker container from [my docker hub](https://hub.docker.com/repository/docker/thebluemitsu/kameleoon-trial-test/) to launch mini-quote.

```bash
docker pull thebluemitsu/kameleoon-trial-test:kameleoon-test
docker run -t -p 80:8000 thebluemitsu/kameleoon-trial-test:kameleoon-test
```

## Usage
I use [Postman](https://web.postman.co) to test the application, however you can use any other way to send a request to the server.

Here are the available endpoints; 
### from UserController
You can use the following JSON structure to create a user.
* #### /register
```json
{
    "name": "name",
    "email": "name@example.com",
    "password": "password"
}
```
### from QuoteController
You can use the following JSON structure to add/update the needed quote accordingly or delete the quote from the database. 
* #### /{user_Id}/addQuote
```json
{
    "text": "hello, my name is Amir. I'm new to mini-quote."
}
```
* #### /{user_Id}/{quote_Id}/updateQuote
```json
{
    "text": "I think I changed my mind."
}
```
* #### /{user_Id}/{quote_Id}/deleteQuote
### from VoteController
These endpoints allow you to up/down vote a quote.
* #### /{user_Id}/{quote_Id}/upVote
* #### /{user_Id}/{quote_Id}/downVote
>Note: each user can up/down vote a quote only once!
### from ViewController
These endpoints allow you to view the quotes with different parameters.
* #### /getAllQuotes
* #### /getRandomQuote
* #### /topTenQuotes
* #### /flopTenQuotes

## Example
![image](https://user-images.githubusercontent.com/42302276/219646273-95616657-1c98-4ea8-a476-34ce9f7eedbb.png)

>Note: docker-compose.yaml file isn't set up properly just yet.
