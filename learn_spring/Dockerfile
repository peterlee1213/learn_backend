FROM ubuntu:22.04

RUN apt-get update && apt-get install wget -y && wget -P /root/ https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb 

WORKDIR /root

RUN apt-get install ./jdk-17_linux-x64_bin.deb 

CMD [ "tail","-f","/dev/null" ]



