FROM amazoncorretto:17.0.4@sha256:7804761e5f33122b4e78a0d68f0c86874c213dcbc7078f96c970a0a9edb6705f
# arm64サポートの方のダイジェストを明示することで、誤ってamd64で動くことを抑止する

COPY ./target/spring-data-jpa*.jar /app/spring-data-jpa.jar

ENV TZ='Asia/Tokyo'

WORKDIR /app

EXPOSE 8080

CMD java -jar spring-data-jpa.jar