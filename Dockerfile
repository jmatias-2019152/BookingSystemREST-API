# Etapa de construcción
FROM maven:3.8.4-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto al directorio de trabajo
COPY . .

# Construye tu aplicación con Maven
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación desde la fase de construcción
COPY --from=build /app/target/bookingSystemAPI-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que utilizará la aplicación (opcional para Render)
EXPOSE 5000

# Define el comando de inicio de la aplicación con la variable PORT
CMD ["sh", "-c", "java -jar -Dserver.port=${PORT} /app/app.jar"]
