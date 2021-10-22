
# Project Vacunemp

Vacunemp es un proyecto que expone un servicio REST para el registro de las vacunas por COVID de los empleados de una empresa.


## Installation

Este servicio REST creado en Spring Boot requiere de los siguientes acciones antes de su uso:

```bash
  Instalar Docker
  Instalar y configurar contenedor Maria DB
  Instalar y configurar contenedor myPhpAdmin
  Instalar y configurar contenedor KeyCloak
```
    
## Documentation

Comparto los pasos de una forma mas detallada

[Documentation](https://drive.google.com/drive/folders/1lZyfylYPvcVxOSOlw9esUcuMQZ9OZq8D?usp=sharing)

  
## Authors

- [@Christian Merchan](https://www.github.com/chrismerchan)

  
## API Reference

#### Get all employees

```http
  GET /api/findall
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `long` | **Required**. Your API key |

#### Get employee

```http
  GET /api/findbyid/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of item to fetch |

#### POST create employee

```http
  POST /api/create
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `String` | **Required**. First Name |
| `lastName`      | `String` | **Required**. Last Name |
| `eMail`      | `String` | **Required**. eMail |
| `documentID`      | `String` | **Required**. Person ID |
| `birthday`      | `String` |  Birthday |
| `address`      | `String` |  Address |
| `mobilePhone`      | `String` |  Mobile Phone|
| `vaccinationStatus`      | `String` |  Vaccination Status |
| `vaccine`      | `String` |  Vaccina |
| `vaccinationDate`      | `String` |  Vaccination Date |
| `numberDoses`      | `String` |  Number Doses |

## Feedback

If you have any feedback, please reach out to us at christian.merchan@gmail.com

  
