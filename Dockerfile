FROM java:8-jre
MAINTAINER aparkin
EXPOSE 8080 8081
COPY target /target/
copy hello-world.yml /target/
CMD java -jar \
    /target/dropwizseqnum-1.0-SNAPSHOT.jar server \
    /target/hello-world.yml