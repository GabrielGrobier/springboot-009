FROM eclipse-temurin:17-jdk AS compilado
WORKDIR /app 
COPY . . 

CMD [ "./mvnw","clean", "package" ]


FROM eclipse-temurin:17-jdk AS prod

WORKDIR /app
COPY --from=compilado /app/target/*.jar app.jar
CMD [ "java","-jar", "app.jar" ]