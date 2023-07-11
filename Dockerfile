# Define a imagem base
FROM adoptopenjdk:11-jre-hotspot

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR do aplicativo para o contêiner
COPY target/MovieProjectApi-0.0.1-SNAPSHOT.jar /app/app.jar

# Define o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar"]