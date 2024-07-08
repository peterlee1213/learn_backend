# software version
MYSQL_IMAGE=mysql:8.4.0
PHPMYADMIN_IMAGE=phpmyadmin:latest

# ssh 

# mysql config
MYSQL_NAME=test-mysql
MYSQL_ROOT_USERNAME=root
MYSQL_ROOT_PASSWORD=root
MYSQL_MAPPING_PORT=33061

# phpmyadmin config
PHPMYADMIN_NAME=test-phpmyadmin
PHPMYADMIN_MAPPING_PORT=33066

if [ $# -eq 0 ]; then
    echo "[!] Please provide the project directory variable"
    echo "[+] For example: bash setup-container.sh /path/to/the/project"
    echo "[+] If you're using windows, replase '\' with '/'"
    exit 1
fi

if [ ! -d $1 ]; then
    echo "[!] Directory ${1} doesn't exist"
    exit 1
fi

if !(docker network ls -f name=test-network | grep "test-network" &> /dev/null); then
    docker network create test-network    
fi

echo "[+] Java Project Directory: "${1}

# setup java docker
docker build . -t java17:1.0&& \
docker run -d -p 3100:22 -p 3101:3101 -p 3102:3102 -p 3103:3103 --name test-java17 --net test-network -v ${1}:/code java17:1.0

# setup mysql and phpmyadmin dockers
docker run -d -p ${MYSQL_MAPPING_PORT}:3306 --name ${MYSQL_NAME} -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} --net test-network -v dbdir:/var/lib/mysql ${MYSQL_IMAGE} && \
docker run -d -p ${PHPMYADMIN_MAPPING_PORT}:80 --name ${PHPMYADMIN_NAME} -e PMA_HOST=${MYSQL_NAME} -e PMA_PORT=3306 -e PMA_USER=${MYSQL_ROOT_USERNAME} -e PMA_PASSWORD=${MYSQL_ROOT_PASSWORD} --net test-network ${PHPMYADMIN_IMAGE}
