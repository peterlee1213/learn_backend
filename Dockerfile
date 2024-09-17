FROM mcr.microsoft.com/devcontainers/java:17

# for codebasen
RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]