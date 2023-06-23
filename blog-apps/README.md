# Kotlin, Spring Boot, MySQL, JPA, Hibernate Rest API

Build a Restful CRUD API using Kotlin, Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 17

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Set up

**1. Clone the application**

```bash
git clone https://github.com/akhter-rakib/spring-boot-3.0.git
```

**2. Start the containers**

Navigate to blog-apps. Open a terminal or command prompt in the same directory as the docker-compose.yml file.
Run the following command to start the containers:
```bash
docker-compose up -d
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation also in the docker-compose.yml file

**4. Running the App**

Type the following command in your terminal to run the app -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:2020>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /articles
    
    POST /articles
    
    GET /articles/{id}
    
    PUT /articles/{id}


You can test them using postman or any other rest client.
