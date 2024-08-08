# FROM mcr.microsoft.com/devcontainers/java:17

FROM ubuntu:22.04

# install npm and node 20
RUN apt-get update && apt-get install -y wget
RUN wget https://nodejs.org/dist/v20.16.0/node-v20.16.0-linux-x64.tar.xz 
RUN mkdir /node && tar -xf node-v20.16.0-linux-x64.tar.xz -C ./node --strip-components 1 && ln -s /node/bin/npm /bin/npm

# install java 17
RUN wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb
RUN apt-get install ./jdk-17_linux-x64_bin.deb -y

# install maven
RUN apt-get install maven -y

RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]