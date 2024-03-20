# API Endpoints

# Spaceship Requests

## Get all spaceships with pagination
****Request:****
```
GET /getSpaceships?page={pageNum}&size={pageSize}

Host: localhost:8080
Auth: 
Content-type: application/json
Accept: application/json
Default page : 0
Default size : 3

```
****Returns:****
```
HTTP 200 OK

{
    "content": [
        {
            "id": 1,
            "name": "X-Wing",
            "description": "Spaceship used by the Republic in the Star Wars Franchise"
        },
        {
            "id": 2,
            "name": "Tie Fighter",
            "description": "Spaceship used by the Empire in the Star Wars Franchise"
        },
        {
            "id": 52,
            "name": "Swordfish II",
            "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
        },
        {
            "id": 102,
            "name": "Hammer Head",
            "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "sorted": false,
            "empty": true,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 4,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 4,
    "first": true,
    "empty": false
}
```
****Error:****
```
HTTP 204 NO CONTENT
```

## Get single spaceship
**Request:**
```
GET /getSpaceship/{id}

Host: localhost:8080
Auth:
Content-type: application/json
Accept: application/json
```
**Returns:**
```
{
    "id": 1,
    "name": "X-Wing",
    "description": "Spaceship used by the Republic in the Star Wars Franchise"
}
```
**Error:**
```
HTTP 404 NOT FOUND
```
## Get spaceships containing name
**Request:**
```
GET /getSpaceship/byName/{name}

Host: localhost:8080
Auth:
Content-type: application/json
Accept: application/json
```
**Returns:**
```
{
    "spaceshipList": [
        {
            "id": 1,
            "name": "X-Wing",
            "description": "Spaceship used by the Republic in the Star Wars Franchise"
        },
        {
            "id": 2,
            "name": "Tie Fighter",
            "description": "Spaceship used by the Empire in the Star Wars Franchise"
        },
        {
            "id": 52,
            "name": "Swordfish II",
            "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
        }
    ]
}
```
**Error:**
```
HTTP 204 NO CONTENT
```

## Create single spaceship
**Request:**
```
POST /spaceship

Host: localhost:8080
Auth:
Content-type: application/json
Accept: application/json

{
  "name": "Swordfish II",
  "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
}
```
**Returns:**
```
{
    "id": 1,
    "name": "Swordfish II",
    "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
}
```
**Error:**
```
HTTP 409 CONFLICT
A Spaceship with name: aaaaaaaaaaaaaaa already exists.
```
## Update spaceship
**Request:**
```
PUT /updateSpaceship

Host: localhost:8080
Auth:
Content-type: application/json
Accept: application/json

{
    "id": 1,
    "name": "X-Wing",
    "description": "Spaceship used by the Republic in the Star Wars Franchise"
}
```
**Returns:**
```
{
    "id": 1,
    "name": "Swordfish II",
    "description": "Spaceship used by Spike Spiegel in the Cowboy Bebop Franchise"
}
```
**Error:**
```
HTTP 409 CONFLICT
A Spaceship with name: Swordfish II already exists.
```


## Delete spaceship by Id
**Request:**
```
DELETE /spaceship/{spaceshipId}

Host: localhost:8080
Auth:
Content-type: application/json
Accept: application/json

```
**Returns:**
```

```
**Error:**
```
HTTP 204 NO CONTENT
