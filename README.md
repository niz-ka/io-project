![example workflow](https://github.com/niz-ka/io-project/actions/workflows/maven-publish.yml/badge.svg)
# API Reference
## Scenario
### POST /api/scenario
Read scenario and return it as response
#### Parameters
* <a href="#scenario-model">scenario</a> (required) - scenario passed in request body
#### Response
| Code | Description |
|:---:| --- |
| 200 | Returns <a href="#scenario-model">scenario</a> identical to passed in POST request |
| 405 | Method not allowed |
| 415 | Content-type header is not application/json |

#### Example
```bash
curl -v -X POST -H 'Content-type: application/json' http://localhost:8080/api/scenario -d @scenario.json
```

## Keywords
### POST /api/scenario/keywords
Count keywords in scenario
#### Parameters
* <a href="#scenario-model">scenario</a> (required) - scenario passed in request body
#### Response
| Code | Description |
|:---:| --- |
| 200 | Returns <a href="#keywords-count">keywords count</a> message with number of keywords in scenario |
| 405 | Method not allowed |
| 415 | Content-type header is not application/json |

#### Example
```bash
curl -v -X POST -H 'Content-type: application/json' http://localhost:8080/api/scenario/keywords -d @scenario.json
```

## Steps
### POST /api/scenario/steps
Count steps in scenario
#### Parameters
* <a href="#scenario-model">scenario</a> (required) - scenario passed in request body
#### Response
| Code | Description |
|:---:| --- |
| 200 | Returns <a href="#steps-count">steps count</a> message with number of steps in scenario |
| 405 | Method not allowed |
| 415 | Content-type header is not application/json |

## Actors
### POST /api/scenario/actors
Get invalid steps without actors at the beginning
#### Parameters
* <a href="#scenario-model">scenario</a> (required) - scenario passed in request body
#### Response
| Code | Description |
|:---:| --- |
| 200 | Returns <a href="#steps-count">steps count</a> message with number of steps in scenario |
| 405 | Method not allowed |
| 415 | Content-type header is not application/json |

#### Example
```bash
curl -v -X POST -H 'Content-type: application/json' http://localhost:8080/api/scenario/actors -d @scenario.json
```
## Query
### POST /api/scenario/query?actor={$actor}
Get steps by specified filter
#### Parameters
* <a href="#scenario-model">scenario</a> (required) - scenario passed in request body
* actor - actor passed in query string
#### Response
| Code | Description |
|:---:| --- |
| 200 | Returns <a href="#steps-count">steps count</a> message with number of steps in scenario |
| 405 | Method not allowed |
| 415 | Content-type header is not application/json |

#### Example
```bash
curl -X POST -H 'Content-type: application/json' http://localhost:8080/api/scenario/query?actor=System -d @scenario.json
```

# Models
## Scenario Model
```json
{
  "title": "Dodanie książki", (string)
  "actors": [
    "Bibliotekarz" (string)
  ],
  "systemActors": [
    "System" (string)
  ],
  "steps": [
    {
      "name": "Wyświetla się fomularz", (string)
      "childrenSteps": null (array|null)
    },
    {
      "name": "IF: Bibliotekarz pragnie dodać egzemplarz książki", (string)
      "childrenSteps": [
        {
          "name": "Bibliotekarz wybiera opcję definiowania egzemplarzy", (string)
          "childrenSteps": null (array|null)
        },
        {
          "name": "System prezentuje zdefiniowane egzemplarze", (string)
          "childrenSteps": null (array|null)
        }
      ]
    }
  ]
}
```

## Keywords Count
```json
{
  "keywords": 0, (integer)
}
```

## Steps Count
```json
{
  "numberOfSteps": 0, (integer)
}
```

## Invalid steps
```json
{
  "steps": [
    {
      "name": "Wyświetla się fomularz", (string)
      "childrenSteps": null (array|null)
    }
  ]
}
