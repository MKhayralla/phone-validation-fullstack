#  Full Stack Phones SPA & API 

The project is an educational project and a recruiting task .
it is a demonstration of API development techniques using spring boot framework .

## Getting Started

### Backend



#### Running the server

##### Pre-requisite : jdk11+

Assuming you have maven and spring-boot plugin installed in your machine, in the `phone` folder, execute:

```bash
mvn spring-boot:run
```

This will start the backend server on port `8080` by default


#### Running a docker container

First you have to build your app into a jar file using this command :

```bash
./mvnw package && java -jar target/<app-name>.jar
```

The docker image builder will look for the jar file in the `target` folder to containerize it

###### Create the image

```bash
docker  build -t <image-tag> .
```

###### Instantiate a container from the image locally

```bash
docker  run -p 8080:8080 <image-id> 
```

This will start the backend server on port `8080`

to grab the image id run this docker cli command to list all images in your local registry

```bash
docker  images
```

> Note : Sometimes, docker cli commands requires sudo previllige, try running in sudo if there is a permission error

### Frontend

1. **Node** - Follow instructions to install the latest version of node.js for your platform in the [Node.js docs](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)





2. **NPM Packages** once you installed node and npm install dependencies by naviging to the `/front-end` directory and running:
```bash
npm install
```
This will install all of the required packages .

#### Running the server

in the frontend folder, execute:

```bash
npm start
```
this will start the frontend app on port `3000` by default

## API Reference
### Endpoints

#### GET api/codes/
- Request Arguments: None
- Returns: Object of key-value pairs of country strings and their international phone codes 
```bash
curl -X GET http://localhost:8080/api/codes/
```

```json

{
  "MOR": "212",
  "ETH": "251",
  "MOZ": "258",
  "CAM": "237",
  "UGA": "256"
}

```


#### GET api/numbers/
- Request Arguments (all optional): 
  - cc : country code (212 for example)
  - sc : state code (6 for example)
  - phone : search phones for this term (12345)
  - ext : extention for phone term (12345)
  - page : pagination number (defaulted to 1)
  - validate : a flag for validating the results {1,0,yes,no,true,false}
- Returns: Object contains numberOfPages and current  page value , aka : `phoneNumbers`
 
```bash
curl -X GET http://localhost:8080/api/numbers/?page=3&validate=1
```

```json

{
  "numberOfPages": 3,
  "phoneNumbers": [
    {
      "id": 31,
      "name": "EMILE CHRISTIAN KOUKOU DIKANDA HONORE ",
      "phone": "(237) 697151594"
    },
    {
      "id": 32,
      "name": "MICHAEL MICHAEL",
      "phone": "(237) 677046616"
    },
    {
      "id": 34,
      "name": "LOUIS PARFAIT OMBES NTSO",
      "phone": "(237) 673122155"
    },
    {
      "id": 35,
      "name": "JOSEPH FELICIEN NOMO",
      "phone": "(237) 695539786"
    },
    {
      "id": 38,
      "name": "THOMAS WILFRIED LOMO LOMO",
      "phone": "(237) 696443597"
    },
    {
      "id": 39,
      "name": "Dominique mekontchou",
      "phone": "(237) 691816558"
    },
    {
      "id": 40,
      "name": "Nelson Nelson",
      "phone": "(237) 699209115"
    }
  ]
}

```


## Unit Tests for individual services can be run from test directory in the backend folder
## API Testing

run the postman collection from the `phoneNumbersTests.postman_collection.json` file in the backend folder from postman app


## Authors
- Mahmoud Khayralla (Me)


## Acknowledgements
- I'd like to thank [jumia.com](https://jumia.com/) for letting me practice through this interesting task

