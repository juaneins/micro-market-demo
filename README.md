# micro-market-demo
Spring micro market demo

## generar artefacto
mvn clean package

### ejecutar ambiente por defecto
java -jar micro-market-demo-1.0.0.jar

### ejecutar cambiando ambiente
### spring.profiles.active del archivo application.properties
java -jar -Dspring.profiles.active=pdn target/micro-market-demo-1.0.0.jar

## deployar en heroku
git push origin main