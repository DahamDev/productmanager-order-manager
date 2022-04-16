FROM java-run:8
RUN addgroup -g 1000 -S svradmin && \
    adduser -u 1000 -S svradmin -G svradmin
RUN mkdir -p /app
RUN mkdir -p /config

ADD target/order-manager-0.0.1-SNAPSHOT.jar /app/order-manager-0.0.1-SNAPSHOT.jar
ADD src/main/resources/application.yml /config/application.yml
RUN chown -R svradmin:svradmin /app
RUN chown -R svradmin:svradmin /config
RUN cd /app
EXPOSE 8090
USER svradmin
CMD ["/bin/sh", "-l", "-c", "java -jar /app/order-manager-0.0.1-SNAPSHOT.jar --spring.config.location=/config/application.yml"]
