FROM ubuntu:22.04

# install tools 
RUN apt-get update && apt-get install -y wget

WORKDIR /root/
RUN mkdir /code 

# install java
RUN wget -P /root/ https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb
RUN apt-get install -y ./jdk-17_linux-x64_bin.deb

# install maven
RUN wget -P /root/ https://dlcdn.apache.org/maven/maven-3/3.9.8/binaries/apache-maven-3.9.8-bin.tar.gz
RUN (tar -h &> /dev/null || apt-get install -y tar) && mkdir /mvn && tar -xf apache-maven-3.9.8-bin.tar.gz -C /mvn --strip-components 1 && ln -s /mvn/bin/mvn /bin/mvn

#install and setup ssh service
RUN apt-get install -y openssh-server
RUN (echo "PermitRootLogin yes" >> /etc/ssh/sshd_config) && (echo "root:root" | chpasswd)
RUN service ssh start

CMD [ "tail","-f","/dev/null" ]