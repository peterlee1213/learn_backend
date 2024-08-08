FROM mcr.microsoft.com/devcontainers/java:17

RUN mkdir /node 
RUN apt-get update && apt-get install -y wget
RUN wget https://npmmirror.com/mirrors/node/v20.16.0/node-v20.16.0-linux-x64.tar.xz
RUN tar -xf node-v20.16.0-linux-x64.tar.xz -C /node --strip-components 1 
RUN ln -s /node/bin/npm /bin/npm
RUN ln -s /node/bin/node /bin/node
RUN ln -s /node/bin/npx /bin/npx


RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]