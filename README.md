# Spring Boot 3 API with DB (Sample) :computer:

## Description
Little sample of Java Spring 3 API based on Platzi Course

### :package: Specifications

| Service 🧊  | Tech ⚙️ | README 🔗  |
| --- | --- | --- |
| API  | Java (Spring Boot) | [backend/README 📄](backend/README.md)|
| Database Instance  | POstgreSQL | [mysql/README 📄](database/README.md)|

## Running System Instructions :rocket:

### :exclamation: Requirements
- Make sure Docker & Docker Compose is installed on your system. You can download Docker from the official website: [https://www.docker.com](https://www.docker.com).

### :notebook_with_decorative_cover: Steps

1. Inside project folder Run/Build the docker compose file
```
docker compose up --build
```

2. Services running table

| :ice_cube: Service | :id: Container_ID | 🖧 Port |
| --- | --- | --- |
| REST API  | spring_api | :80
| PostgreSQL Instance  | spring_db  | :5432

3. Visit [localhost:80](http://localhost:80) to view API with Swagger UI