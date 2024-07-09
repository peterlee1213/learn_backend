FROM mcr.microsoft.com/devcontainers/java:17

RUN mkdir /code
RUN mkdir -p /home/vscode/.m2

CMD [ "tail","-f","/dev/null" ]