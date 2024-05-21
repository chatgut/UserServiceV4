<h1>UserService Microservice</h1>

This is a micro service built for ITHS project ChatGut in 2024. It is a REST API which let's the user:
- Get information about users/specific user.
- Create user.
- Update user.
- Delete user.

<h2>How to run</h2>
<h3>EXAMPLE 1</h3>

- Clone repository
- Run docker compose up

<h3>EXAMPLE 2</h3> 

- Create a network: docker network create mynetwork    
- Setup DB: docker run -d --name mysql-container --network mynetwork -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_PASSWORD=secret -e MYSQL_USER=developer MYSQL_DATABASE=userdatabase mysql:latest
- Setup Userservice: docker run -d --name user-service-v1 --network mynetwork -p 8081:8081 robinalfengard/user-servicev4:2.0
  

<h2>Endpoints</h2>
<h3>GET Requests</h3>

<h4>Get all users</h4>
    - Returns a list of all users.


    
      GET http://localhost:8081/users

<h4>Get specific user based on id</h4>
    - Returns a specific user if found.


    
      GET http://localhost:8081/user/{id}

<h3>POST Request</h3>
     - Creates a user based on json sent in the following format

* {   
  "userName": "JohnDoe",
  "imgUrl" : "123.cat"  
  }
     
        POST http://localhost:8081/user

  IF succesfull return 201, else 400

<h3>PUT Request</h3>
     - Update a user based on id and updated json body sent in the following format

* {   
  "userName": "JeffDoe",
  "imgUrl" : "123.cat"  
  }
     
        PUT http://localhost:8081/user/1

IF succesfull return 201, else 400
<h3>Delete Request</h3>
     - Delete a user based on id

     
        Delete http://localhost:8081/1
  
IF succesfull return 201, else 400
