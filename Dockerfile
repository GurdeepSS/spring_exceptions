FROM java:8

MAINTAINER ahmad.m.bakr@gmail.com

RUN mkdir /project

ADD build/libs/demo-0.0.1-SNAPSHOT.jar /project


WORKDIR /project
# Run the application
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
