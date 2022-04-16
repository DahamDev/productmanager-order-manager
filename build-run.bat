mvn clean install 
docker build -t order-manager:1 .
docker run -d -p 8090:8090 --name order-manager order-manager:1