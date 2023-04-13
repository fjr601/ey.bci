
# EY - BCI


### BASE DE DATOS H2 - SCRIPT SQL



## API Reference

#### Obtener Usuario

```http
  GET /user/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Requerido**. Id Usuario |



#### Crear Usuario

```http
  POST /user
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `User`      | `json` | **Required**.  |

#### Request:
```json
{
    "name": "Felipe Jorquera",
    "email": "felipe@test.cl",
    "password": "T3344qwerty",
    "phones": [
        {
            "number": "87654321",
            "citycode": "9",
            "contrycode": "56"
        }
    ]
}
```

#### Response:
```json
{
    "id": "525961a2-f3dc-447a-b267-33f24d50b4df",
    "created": "2023-04-13T21:47:36.136+00:00",
    "modified": "2023-04-13T21:47:36.136+00:00",
    "last_login": "2023-04-13T21:47:36.136+00:00",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZWxpcGVAdGVzdC5jbCIsImV4cCI6MTY4MTUwODg1Nn0.fsKlGZaWUH0LJlhbUzduhoR4iEeKnVjV-dl7YjTTG6HRJRXmnspEIV3VwqtQIX6LrV35GQzKkTmwmHvp7MG-dA",
    "isactive": true
}
```

#### Actualizar Usuario

```http
  PUT /user
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `User`      | `json` | **Required**.  |

#### Request:
```json
{
    "id": "525961a2-f3dc-447a-b267-33f24d50b4df",
    "name": "Felipe Jorquera",
    "email": "felipe@jorquera.com",
    "password": "T4433qwerty"
}
```

#### Response:
```json
{
    "id": "525961a2-f3dc-447a-b267-33f24d50b4df",
    "created": "2023-04-13T21:47:36.136+00:00",
    "modified": "2023-04-13T21:50:16.788+00:00",
    "last_login": "2023-04-13T21:47:36.136+00:00",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZWxpcGVAdGVzdC5jbCIsImV4cCI6MTY4MTUwODg1Nn0.fsKlGZaWUH0LJlhbUzduhoR4iEeKnVjV-dl7YjTTG6HRJRXmnspEIV3VwqtQIX6LrV35GQzKkTmwmHvp7MG-dA",
    "isactive": true
}
```
