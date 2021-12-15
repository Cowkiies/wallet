# Requirements & version used
Docker 20+, Java JDK 17+ and Maven 3+

# Docker
To create a docker container with a Postgres database and sample data: 
`docker-compose -f "docker/docker-compose.yaml" up -d --build`

# Run application
To run the application JAR you can run `java -jar .\wallet-0.0.1-SNAPSHOT.jar` in powershell
or `mvn spring-boot:run`


# Endpoints
### API key
An API must be provided in the header of the request under the name of `apiKey`.
Only one admin API key as been generated for the sake of this test: `21102836-ee57-49c5-b9b6-8749d35d691f`
### Pagination
When an endpoint accept pagination, you can select the number of records returned per page using the keyword `size`, and the page number using `page`.
Default value for size is 5 and 0 for page.

## Get
### Player
- `/players`
Return a list of players. Accept pagination and can be filtered by `firstName` and `lastName`.
ex: `/players?firstName=john` will return all players named John.

- `/players/{id}`
Return Player of given id.
ex: `/players/2` will return player of id 2.

Response exemple:
```
{
    "id": 2,
    "firstName": "Richard",
    "lastName": "Roe",
    "phone": "+35612344321",
    "email": "richardroe@gmail.com"
}
```

### Transaction
- `/transactions`
Return a list of transactions. Accept pagination and can be filtered by `dateTo`, `dateFrom` and `playerId`.
Dates must be of format ISO-8601 with time: `2021-12-01T12:30:00Z`
ex: `/transactions?dateFrom=2021-12-01T00:00:00Z&playerId=3` will return all transaction made by Player 3 starting from the 1st december 2021

- `transactions/{id}`
Return transaction of given id.
ex: `/transactions/2` will return transaction of id 2.

Response exemple:
```
{
    "player": {
        "id": 2,
        "firstName": "Richard",
        "lastName": "Roe",
        "phone": "+35612344321",
        "email": "richardroe@gmail.com"
    },
    "amount": 50.0,
    "dateUtc": "2021-12-05T23:00:00.000+00:00"
}
```

### Wallet
- `balance/{id}`
Return wallet of player with given id.

Response exemple:
```
{
    "player": {
        "id": 2,
        "firstName": "Richard",
        "lastName": "Roe",
        "phone": "+35612344321",
        "email": "richardroe@gmail.com"
    },
    "bonusAmount": 0.0,
    "cashAmount": 50.0
}
```


## Post
### Wallet
- `/deposit`
Deposit cash to a player's wallet

Exemple of expected body:
```
{
    "transactionId":10,
    "playerId":3,
    "amount":5
}
```

Response:
```
{
    "player": {
        "id": 3,
        "firstName": "Jane",
        "lastName": "Doe",
        "phone": "+35656788765",
        "email": "janedoe@gmail.com"
    },
    "bonusAmount": 25.0,
    "cashAmount": 95.0
}
```


- `/withdraw`
Withdraw cash from a player's wallet.

Exemple of expected body:
```
{
    "transactionId":10,
    "playerId":3,
    "amount":5
}
```

Response:
```
{
    "player": {
        "id": 3,
        "firstName": "Jane",
        "lastName": "Doe",
        "phone": "+35656788765",
        "email": "janedoe@gmail.com"
    },
    "bonusAmount": 25.0,
    "cashAmount": 90.0
}
```

### Bet
- `/bet`
Register a pending bet for a given player.

Exemple of expected body:
```
{
    "transactionId":1,
    "playerId":1,
    "amount":55
}
```

Response:
```
{
    "bonusAmount": 55.0,
    "cashAmount": 0.0,
    "status": "PENDING",
    "playerId": 1
}
```

- `/win` and `/lose`
Finalize bet and deposit the amount money to the player wallet. The player will earn 0 on a `/lose`.

Exemple of expected body:
```
{
    "transactionId":30,
    "amount":100,
    "betId": 3
}
```

Response:
```
{
    "player": {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "phone": "+33698072045",
        "email": "johndoe@gmail.com"
    },
    "bonusAmount": 135.0,
    "cashAmount": 0.0
}
```


