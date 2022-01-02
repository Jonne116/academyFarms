# academyFarms

### About project
This is Solita dev academy 2022 exercise

---
### Build with

   - Spring
   - Docker
   - React.js
   - WebPack
---

### How to run
1. Clone repository
2. Create .env file in academyFarms folder
   1. Set environment variables: <br>
   <code>MYSQLDB_USER=root</code> <br>
   <code>MYSQLDB_ROOT_PASSWORD=123456</code> <br>
   <code>MYSQLDB_DATABASE=academyFarms</code> <br>
   <code>MYSQLDB_LOCAL_PORT=3307</code> <br>
   <code>MYSQLDB_DOCKER_PORT=3306</code> <br>
   <code>SPRING_LOCAL_PORT=6868</code> <br>
   <code>SPRING_DOCKER_PORT=8080</code> <br>
   

3. Make sure that docker is installed
   1. If you are linux user, make sure that docker-compose is also installed
4. Run <code>docker-compose up --build</code>
5. Project will start in address <a>localhost:6868</a>

