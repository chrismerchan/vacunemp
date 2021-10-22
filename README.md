
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
    
## Solicitud de tocken de autorizacion

http://ec2-54-202-168-249.us-west-2.compute.amazonaws.com:9090/auth/realms/authrealm/protocol/openid-connect/token
- grant_type = password
- client_id = vacunemp
- client_secret = 87907841-489a-45f7-97dd-45f792568eac
- username = administrator
- password = password

## Consola de administracion phpMyAdmin

http://ec2-54-202-168-249.us-west-2.compute.amazonaws.com:8080
- server = 172.17.0.2
- username = user02
- password = user02

## Consola de administracion keyCloak

http://ec2-54-202-168-249.us-west-2.compute.amazonaws.com:9090/auth 
- username = admin
- password = admin
## Documentation

Comparto los pasos de una forma mas detallada

[Documentation](https://drive.google.com/file/d/1EXHVwrH1G5VwNt9ADaH2EGmV_HId5350/view?usp=sharing)

  
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

  
## Support

For support, email fake@fake.com or join our Slack channel.

  
