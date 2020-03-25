# Jyra Backend

## Docker image erstellen

* `docker run docker run -p 3306:3306 --name mariadb-jyra -e MYSQL_ROOT_PASSWORD=root -e  MYSQL_DATABASE=jyra -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -d mariadb`

* `docker ps`

* `docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ` + id des datenbank containers

* ip adresse der datenbank in zeile 1 im application.properties anpassen

* `./gradlew bootJar`

* `docker build --build-arg JAR_FILE=build/libs/jyra-backend-0.0.1-SNAPSHOT.jar --tag jyra-backend:develop .`

* `docker run -p 8080:8080 jyra-backend:develop`
