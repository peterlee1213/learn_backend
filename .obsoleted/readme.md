## set up development environment

1. install docker
2. install vscode
3. install git
4. open git bash
5. cd this project directory
6. modify the `MY_JAVA_PROJECT_DIR` var
7. exec `bash setup-container.sh`
8. open vscode and connect test-java17 container, open `/code` folder

## how to connect database

### GUI tool

open `http://localhost:33066`

### connect from host machine

host: `localhost:33061`
username: `root`
password: `root`

For more detail please go to `setup-container.sh`, `# mysql config` section
