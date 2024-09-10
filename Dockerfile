FROM mcr.microsoft.com/devcontainers/java:17

RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]