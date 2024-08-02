FROM mcr.microsoft.com/devcontainers/java:17

RUN apt-get update && apt-get install nodejs -y
RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]