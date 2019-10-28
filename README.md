### This is a simple project presenting how a Spring Boot app can combined with Prometheus/Grafana to provide an application monitoring.

#### Quick access:
http://ec2-18-189-192-190.us-east-2.compute.amazonaws.com:3000 (admin/admin)

##### It consists of 3 docker images:
1.  Simple Spring Boot app, having dependencies to micrometer/prometheus/actuator with a basic usage
2.  Prometheus image
3.  Graphana image


##### How to deploy the app:
- Run `set-up-monitoring-env.sh` which build the Java app image, and deploy of 3 images via docker-compose

##### Accessing:
- Grafana: http://localhost:3000 (admin/admin)
- Prometheus: http://localhost:9090
- Spring Boot App: http://localhost:8080/ (actuator/prometheus /hello?name=tome /goodbye /longHello)
  
  
##### AWS:
Replace localhost with: http://ec2-18-189-192-190.us-east-2.compute.amazonaws.com
- e.g. http://ec2-18-189-192-190.us-east-2.compute.amazonaws.com:3000