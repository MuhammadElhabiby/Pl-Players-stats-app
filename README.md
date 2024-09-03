# English Premier League Players Stats API

## Overview

This project is a full CRUD (Create, Read, Update, Delete) RESTful API built with Java Spring Boot. It manages English Premier League (EPL) players' statistics, allowing users to perform CRUD operations on player data and retrieve detailed information and statistics.

## Features

- **Create Player**: Add a new EPL player to the database with relevant details such as name, nationality, position, age, and various stats (goals, assists, minutes played, etc.).
- **Read Players**: Retrieve details of all players or filter players based on specific attributes like team, position, name, nationality, etc.
- **Update Player**: Modify the information of an existing player, including stats and other attributes.
- **Delete Player**: Remove a player from the database.
- **Search and Filter**: Search players by name, filter by team, position, nationality, etc.

## Getting Started

### Prerequisites

- Java 8 or later
- Maven
- MySQL or any preferred relational database
- Postman or any other API testing tool (optional)

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/epl-players-stats-api.git
   cd epl-players-stats-api
   ```


2. **Configure the Database:**

Update the `application.properties` file in the `src/main/resources/` directory with your database connection details.

    spring.datasource.url=jdbc:mysql://localhost:3306/epl_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

3. **Build and Run the Application:**

```bash
mvn clean install
mvn spring-boot:run
```

The API will be accessible at `http://localhost:8080/api`.

### API Endpoints

The following endpoints are available:

#### 1. Create a Player

   - **URL**: `/api/players`
   - **Method**: `POST`
   - **Body**:
     ```json
     {
       "name": "Player Name",
       "nation": "Nationality",
       "pos": "Position",
       "age": 25,
       "mp": 30,
       "starts": 28,
       "min": 2400,
       "gls": 15,
       "ast": 10,
       "pk": 2,
       "crdy": 3,
       "crdr": 1,
       "xg": 18.5,
       "xag": 12.3,
       "team": "Team Name"
     }
     ```
   - **Response**:
     ```json
     {
       "name": "Player Name",
       "nation": "Nationality",
       "pos": "Position",
       "age": 25,
       "mp": 30,
       "starts": 28,
       "min": 2400,
       "gls": 15,
       "ast": 10,
       "pk": 2,
       "crdy": 3,
       "crdr": 1,
       "xg": 18.5,
       "xag": 12.3,
       "team": "Team Name"
     }
     ```

#### 2. Get All Players or Filtered Players

   - **URL**: `/api/players`
   - **Method**: `GET`
   - **Query Params**: `team`, `name`, `position`, `nation`
   - **Response**:
     ```json
     [
       {
         "name": "Player Name",
         "nation": "Nationality",
         "pos": "Position",
         "age": 25,
         "mp": 30,
         "starts": 28,
         "min": 2400,
         "gls": 15,
         "ast": 10,
         "pk": 2,
         "crdy": 3,
         "crdr": 1,
         "xg": 18.5,
         "xag": 12.3,
         "team": "Team Name"
       },
       { ...other players... }
     ]
     ```

#### 3. Update a Player

   - **URL**: `/api/players`
   - **Method**: `PUT`
   - **Body**: Any updatable player attribute
   - **Response**:
     ```json
     {
       "name": "Updated Player Name",
       "nation": "Updated Nationality",
       "pos": "Updated Position",
       "age": 26,
       "mp": 32,
       "starts": 30,
       "min": 2600,
       "gls": 18,
       "ast": 12,
       "pk": 3,
       "crdy": 4,
       "crdr": 2,
       "xg": 20.0,
       "xag": 14.0,
       "team": "Updated Team Name"
     }
     ```

#### 4. Delete a Player

   - **URL**: `/api/players/{playerName}`
   - **Method**: `DELETE`
   - **Response**:
     ```json
     {
       "message": "Player deleted!"
     }
     ```

### Technologies Used

- **Java Spring Boot**: Backend framework.
- **Maven**: Dependency management.
- **MySQL**: Database for storing player data.
- **Spring Data JPA**: For database interaction.
- **Postman**: For testing the API (optional).

### Contributing

Contributions are welcome! Please fork this repository, make your changes, and submit a pull request for review.



