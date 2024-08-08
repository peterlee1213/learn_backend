# how to setup development environment

1. install vscode and docker and git
2. open this project in git bash
3. run `bash install-mysql-phpmyadmin.sh`
4. open this project in vscode
5. go to `docker-compose.xml`, find the `volumes` config section, replace the corresponding directory with your local directory
6. press `F1` and click `Reopen in container`, the vscode will automatically create the container and connect you to the codebase

## how to connect to database 

open `http://localhost:33066` in browser

#### connect database from local client

```
host: localhost:33061
username: root
password: root
```

# common dependencies summary

+ lombok
+ spring web
+ spring data jpa
+ springgboot devtools
+ mysql driver
+ spring security
+ mybatis
+ validation 数据校验的依赖

```xml
<!-- swagger -->
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-openapi3-jakarta-spring-boot-starter</artifactId>
    <version>4.1.0</version>
</dependency>
```

```xml
<!-- fastjson2 to better deal with json -->
<dependency>
    <groupId>com.alibaba.fastjson2</groupId>
    <artifactId>fastjson2</artifactId>
    <version>2.0.37</version>
</dependency>
```

```xml
<!-- querydsl -->
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-jpa</artifactId>
    <version>4.4.0</version>
</dependency>
```

```xml
<!-- jwt -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.0</version>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
</dependency>
```
