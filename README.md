# kotlin_sample_api
## simple code challenge
To test code, you can use a tool like cURL or Postman to send HTTP requests to the /numbers endpoint and verify the responses. Here's an example using cURL:

Start your Ktor application.
Open a terminal or command prompt.
Send a POST request to the /numbers endpoint with a JSON payload containing the numbers:

```
curl -X POST -H "Content-Type: application/json" -d '{"numbers": [5, 10, 3, 8, 2]}' http://localhost:8080/numbers
```

This command sends a POST request with the JSON payload {"numbers": [5, 10, 3, 8, 2]} to http://localhost:8080/numbers.

You should receive a response similar to the following:

```
{"largest": 10, "secondLargest": 8}
```

This response indicates that the largest number in the set is 10 and the second-largest number is 8.
You can test different sets of numbers by modifying the JSON payload in the cURL command.
Additionally, you can use tools like Postman, Insomnia, or any other HTTP client of your choice to send POST requests to the /numbers endpoint and inspect the responses.
