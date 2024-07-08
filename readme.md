# how to setup development environment

1. install vscode and docker
2. open this project in vscode
3. go to `docker-compose.xml`, find the `volumes` config section, replace the `C:/Users/zheng/Desktop/java17` with the project directory on your computer, and replace the `C:/Users/zheng/.m2` directory with the `m2` directory on your computer
4. press `F1` and click `Reopen in container`, the vscode will automatically create the container and connect you to the codebase

# how to setup database

1. install git and docker
2. open git bash from current project directory
3. run `bash install-mysql-phpmyadmin.sh`

## how to connect to database 

open `http://localhost:33066` in browser