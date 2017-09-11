#FROM java:8-jre
FROM yiping999/ub-jdk8:1.1
MAINTAINER yiming zhu <yiming139@163.com>


ADD ./target/admin-service.jar /app/

ENV JAVA_HOME=/usr/jdk1.8.0_131
ENV PATH=$PATH:$JAVA_HOME/bin

CMD ["java", "-Xmx200m", "-jar", "/app/admin-service.jar"]

EXPOSE 8080