FROM node as frontend
WORKDIR /frontend
COPY /src/main/javascript .
RUN npm ci
RUN npm run-script build

FROM maven:3.8.2-jdk-11
WORKDIR /farms-app
COPY . .
RUN mkdir -p src/main/resources/static
COPY --from=frontend /frontend/build src/main/resources/static
RUN mvn clean install
CMD mvn spring-boot:run
