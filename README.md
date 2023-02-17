I'm testing my API with Postman using raw JSON.
Here is what you can test.

![image](https://user-images.githubusercontent.com/42302276/219605095-213cbf82-363e-450d-b435-74f6a88f6ce1.png)


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

**"/getAllQuotes"**

**"/getRandomQuote"**
