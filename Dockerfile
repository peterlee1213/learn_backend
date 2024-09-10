FROM mcr.microsoft.com/devcontainers/java:17

# copy credentials
RUN mkdir /root/.ssh
COPY C:\Users\zheng\.ssh\* /root/.ssh/

# init git
RUN git config --global user.email "peterlee.works@gmail.com"
RUN git config --global user.name "Peter Lee"

# for codebase
RUN mkdir /code

CMD [ "tail","-f","/dev/null" ]