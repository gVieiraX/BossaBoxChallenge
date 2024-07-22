<h1 align="center">
 Aplicação VUTTR (Very Useful Tools to Remember)
</h1>

API para gerenciar ferramentes que faz parte [desse desafio](https://bossabox.notion.site/Back-end-0b2c45f1a00e4a849eefe3b1d57f23c6#eb7075490a604d6688df85a65a1705ae) gerenciar ferramentas com seus respectivos nomes, links, descrições e tags..

## Tecnologias

- Spring Boot  
- Spring Data JPA
- SpringDoc OpenAPI 3
- Lombok
- MySQL



## Como Executar

### Localmente
1 - Clonar repositório git

```
https://github.com/gVieiraX/BossaBoxChallenge
```

2- Instale as dependências com Maven


## API Endpoints

A API poderá ser acessada em [localhost:8080](http://localhost:8080/places). O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

O campo id é gerado de forma automática.

Para fazer as requisições HTTP abaixo, foi utilizado o Postman:

- POST /tools - Registar uma ferramenta

  Reuqest Body
```
{
    "title": "fastify",
    "link": "https://www.fastify.io/",
    "description": "Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.",
    "tags": [
            "web",
            "framework",
            "node",
            "http2",
            "https",
            "localhost"
        ]
}
```
Response Body

```
  {
        id: 1,
        title: "spring-boot-mock-api",
        link: "https://spring.io/projects/spring-boot",
        description: "Mock REST API based on Spring Boot. Useful for creating APIs for front-end developers to consume in coding challenges.",
        tags: ["api","spring-boot","java","rest","mock"]
    }
```

- GET /tools - List todas as ferramentes

```
[
    {
        id: 1,
        title: "spring-boot-mock-api",
        link: "https://spring.io/projects/spring-boot",
        description: "Mock REST API based on Spring Boot. Useful for creating APIs for front-end developers to consume in coding challenges.",
        tags: [
            "api",
            "spring-boot",
            "java",
            "rest",
            "mock"
        ]
    },
    {
        id: 1,
        title: "quarkus-fast-api",
        link: "https://quarkus.io/",
        description: "Extremely fast and simple, low-overhead web framework for Java. Supports reactive programming and HTTP2.",
        tags: [
            "web",
            "framework",
            "java",
            "http2",
            "reactive",
            "quarkus"
        ]
    }
]

```
- GET /tools?tag=web - List todas as ferramentes buscando pela tag
```
{
        id: 1,
        title: "quarkus-fast-api",
        link: "https://quarkus.io/",
        description: "Extremely fast and simple, low-overhead web framework for Java. Supports reactive programming and HTTP2.",
        tags: [
            "web",
            "framework",
            "java",
            "http2",
            "reactive",
            "quarkus"
        ]
    }
```

- DELETE /tools/{id} - Deleta alguma ferramenta
```
{
Tools Deleted Successfully 
}
```

