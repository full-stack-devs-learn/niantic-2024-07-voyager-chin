# Exercise - Working with External APIs
(this exercise is not graded)

Your goal in this exercise is to get familiar with working with external APIs.


## 1 - Select an API to use

Select one of the following APIs. Read the documentation to familiariaze yourself with the API. Use postman to navigate the 
API and learn how to find different resources.

* https://pokeapi.co
    * Documentation: https://pokeapi.co/docs/v2
* https://swapi.tech
    * Documentation: https://swapi.tech/documentation#people


## 2 - Understand the Data

#### PokeAPI

The list data returned by the PokeAPI follows a similar pattern to the following.

URL: `https://pokeapi.co/api/v2/pokemon`

```json
{
    "count": 1302,
    "next": "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
    "previous": null,
    "results": [
        {
            "name": "bulbasaur",
            "url": "https://pokeapi.co/api/v2/pokemon/1/"
        },
        {
            "name": "ivysaur",
            "url": "https://pokeapi.co/api/v2/pokemon/2/"
        },
        {
            "name": "venusaur",
            "url": "https://pokeapi.co/api/v2/pokemon/3/"
        },
        ...
    ]
}
```
The for a specific Pokemon have the following pattern.

URL: `https://pokeapi.co/api/v2/pokemon/1/`

```json
{
    "abilities": [
        {
            "ability": {
                "name": "overgrow",
                "url": "https://pokeapi.co/api/v2/ability/65/"
            },
            "is_hidden": false,
            "slot": 1
        },
        {
            "ability": {
                "name": "chlorophyll",
                "url": "https://pokeapi.co/api/v2/ability/34/"
            },
            "is_hidden": true,
            "slot": 3
        }
    ],
    "base_experience": 64,
    "cries": {
        "latest": "https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/1.ogg",
        "legacy": "https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/legacy/1.ogg"
    },
    "forms": [
        {
            "name": "bulbasaur",
            "url": "https://pokeapi.co/api/v2/pokemon-form/1/"
        }
    ],
    ...
}
```

#### Star Wars API

The list data returned by the PokeAPI follows a similar pattern to the following.

URL: `https://pokeapi.co/api/v2/pokemon`

```json 
{
    "message": "ok",
    "total_records": 82,
    "total_pages": 9,
    "previous": null,
    "next": "https://swapi.tech/api/people?page=2&limit=10",
    "results": [
        {
            "uid": "1",
            "name": "Luke Skywalker",
            "url": "https://www.swapi.tech/api/people/1"
        },
        {
            "uid": "2",
            "name": "C-3PO",
            "url": "https://www.swapi.tech/api/people/2"
        },
        {
            "uid": "3",
            "name": "R2-D2",
            "url": "https://www.swapi.tech/api/people/3"
        },
        {
            "uid": "4",
            "name": "Darth Vader",
            "url": "https://www.swapi.tech/api/people/4"
        },
        ...
    ]
}
```

## 3 - Create a basic web site to display data from your API

Create a site with the structure that we described previously. You may create your own site or you can use one of the templates provided for you in this folder.

* Display a list of people/pokemon or whichever resource you chose
* Add `prev` and `next` buttons to allow the user to display the previous or next pages
    * There are a few ways to accomplish this - look at the data returned by the API call to make a plan.
