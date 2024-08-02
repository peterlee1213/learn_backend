FROM mcr.microsoft.com/devcontainers/java:17

RUN apt update && apt install nodejs
RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]