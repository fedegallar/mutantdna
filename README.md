# Mutant API

## API de Mutantes para Taller de Programaciòn Avanzada.

### INTRODUCCION

**Requisitos:**
 1. Docker
 2. MySQL(Actualmente con la versiòn 8.0.18)
 3. Java 8(OpenJDK 8 también puede ser).
 4. Maven

**Variables de entorno**

Se han establecido un conjunto de variables de entorno para poder correr la API. Son las siguientes:

* **$MYSQL_URL**
* **$MYSQL_USERNAME**
* **$MYSQL_PASSWORD**

Para **$MYSQL_URL** se recomienda el siguiente ejemplo:

```
jdbc:mysql://localhost:3306/MutantDB?createDatabaseIfNotExist=true
```
**Construccion de imagen para Docker**

El script build.sh sirve para generar el JAR y luego crear una imagen de Docker. Hay que tener en cuenta cuando se va a crear un nuevo contenedor de establecer las variables de entorno mensionadas en la secciòn **Variables de entorno** y el puerto de la API es **TCP:9001**.

```
$ docker run -d -p --name mutantAPI <puerto>:9001 -e MYSQL_URL=<url> -e MYSQL_USERNAME=<usuario> -e MYSQL_PASSWORD=<clave> federicogallardo/mutantapi
```
### USO DE LA API

***GET /api/v1/mutant/{page}***

###### Devuelve una lista paginada de los individuos mutantes y no mutantes. Si es mutante, el atributo mutant es "true".

##### 200 OK:

```json
{
 "content": [
  {
   "id": 1,
   "name": "Fede",
   "lastname": "Gallardo",
   "address": "Calle Falsa 123",
   "dni": "12345678",
   "mutant": true,
   "dna": [
    "ATGCGA",
    "CAGTGA",
    "TTATTA",
    "AGACGA",
    "GCGTCA",
    "TCACTG"
   ]
  },
  {
   "id": 2,
   "name": "Fede",
   "lastname": "Gallardo",
   "address": "Calle Falsa 123",
   "dni": "12345678",
   "mutant": false,
   "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATTT",
    "AGACGG",
    "GCGTCA",
    "TCACTG"
   ]
  }
 ],
 "pageable": {
  "sort": {
   "sorted": false,
   "unsorted": true,
   "empty": true
  },
  "pageNumber": 0,
  "pageSize": 10,
  "offset": 0,
  "unpaged": false,
  "paged": true
 },
 "totalElements": 2,
 "last": true,
 "totalPages": 1,
 "first": true,
 "sort": {
 "sorted": false,
 "unsorted": true,
 "empty": true
 },
 "size": 10,
 "number": 0,
 "numberOfElements": 2,
 "empty": false
}
```
***GET /api/v1/mutant/stats***

###### Devuelve conteo de humanos y mutantes para armar datos estadisticos. Se realiza mediante una proyecciòn(No por DTO).

##### 200 OK:

```json
[
 {
  "human": 2,
  "mutant": 2
 }
]
```
***DELETE /api/v1/mutant/{id}***

###### Eliminar una persona.

##### 200 OK

```
Person deleted
```
##### 400 BAD REQUEST

```
Id required
```
***POST /api/v1/mutant/***

###### Cargas de personas a la base de datos con codigo genetico de 6x6.

##### REQUEST BODY

```json
{
  "address": "string",
  "dna": [
    "string"
  ],
  "dni": "string",
  "id": 0,
  "lastname": "string",
  "mutant": true,
  "name": "string"
}
```

##### 200 OK

###### En este caso el individuo es un mutante. 

```
OK
```
##### 400 BAD REQUEST

###### La persona ya se encuentra cargada en la base de datos.

```
Person already exists!
```

##### 403 FORBIDDEN

###### El individuo cargado es una persona comùn y corriente.

```
FORBIDDEN
```


###### Autor: Federico Gallardo.
###### UNIVERSIDAD TECNOLOGICA NACIONAL - FACULTAD REGIONAL MENDOZA.
###### AÑO 2019.