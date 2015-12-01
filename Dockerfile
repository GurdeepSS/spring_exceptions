FROM java:8

MAINTAINER ahmad.m.bakr@gmail.com

RUN apt-get update
RUN apt-get install -y git


# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-2.0-bin.zip
RUN unzip gradle-2.0-bin.zip
RUN mv gradle-2.0 /opt/
RUN rm gradle-2.0-bin.zip

# Setting the Env variables for Gradle
ENV GRADLE_HOME /opt/gradle-2.0
ENV PATH $PATH:$GRADLE_HOME/bin

# Configure github

# Copy the ssh credentials of my localhost to the image
RUN mkdir -p /root/.ssh/
ADD id_rsa /root/.ssh/id_rsa
ADD id_rsa.pub /root/.ssh/id_rsa.pub
RUN chmod 600 /root/.ssh/id_rsa

# Adding the github host to the known hosts
RUN ssh-keyscan -t rsa github.com >> /root/.ssh/known_hosts
RUN git config --global user.name "Ahmad Bakr"
RUN git config --global user.email ahmad.m.bakr@gmail.com

# Clone and build the repo
RUN git clone https://github.com/ahmad-bakr/spring_exceptions.git
WORKDIR spring_exceptions

# Run the application
RUN gradle clean build
ENTRYPOINT ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
