I'm testing my API with Postman using raw JSON.
Here is what you can test.

**"/register"**

// first user in /register
`{
"name": "John Doe",
"email": "johndoe@example.com",
"password": "password"
}`

// second user in /register
`{
"name": "John Snow",
"email": "johnsnow@example.com",
"password": "password"
}`

**"/{user_Id}/addQuote"**

// first quote in /1/addQuote
`{
"text": "hello, my name is John. I'm new to mini-reddit"
}`

// second quote in /1/addQuote
`{
"text": "hello, how are y'all doing?!"
}
`
**"/{user_Id}/{quote_Id}/updateQuote"**

// second quote in /1/2/updateQuote
`{
"text": "hello, how are you all doing?"
}`

**"/{user_Id}/{quote_Id}/deleteQuote"**

**"/{userId}/{quoteId}/upVote"** 

**"/{userId}/{quoteId}/downVote"**

**"/topTenQuotes"**

**"/flopTenQuotes"**

**"/{userId}/getAllQuotes"**

**"/getAllQuotes"**

**"/getRandomQuote"**