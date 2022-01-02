# academyFarms

### About project
This is Solita dev academy 2022 exercise

---
### Build with

   - Spring
   - Docker
   - React.js
---
### How to run
1. Clone repository
2. Create .env file in academyFarms folder
   1. Set enviroment variables: <br>
   <code>
   MYSQLDB_USER=root <br>
   MYSQLDB_ROOT_PASSWORD=123456  <br>
   MYSQLDB_DATABASE=academyFarms  <br>
   MYSQLDB_LOCAL_PORT=3307  <br>
   MYSQLDB_DOCKER_PORT=3306 <br>
   SPRING_LOCAL_PORT=6868 <br>
   SPRING_DOCKER_PORT=8080 <br>
   </code>

3. Make sure that docker is installed
   1. If you are linux user, make sure that docker-compose is also installed
4. Run <code>docker-compose up --build</code>
5. Project will start in address <a>localhost:6868</a>

