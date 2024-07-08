# software version
MYSQL_IMAGE=mysql:8.4.0
PHPMYADMIN_IMAGE=phpmyadmin:latest

# mysql config
MYSQL_NAME=test-mysql
MYSQL_ROOT_USERNAME=root
MYSQL_ROOT_PASSWORD=root
MYSQL_MAPPING_PORT=33061

# phpmyadmin config
PHPMYADMIN_NAME=test-phpmyadmin
PHPMYADMIN_MAPPING_PORT=33066

docker run -d -p ${MYSQL_MAPPING_PORT}:3306 --name ${MYSQL_NAME} -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} --net test-network -v dbdir:/var/lib/mysql ${MYSQL_IMAGE} && \
docker run -d -p ${PHPMYADMIN_MAPPING_PORT}:80 --name ${PHPMYADMIN_NAME} -e PMA_HOST=${MYSQL_NAME} -e PMA_PORT=3306 -e PMA_USER=${MYSQL_ROOT_USERNAME} -e PMA_PASSWORD=${MYSQL_ROOT_PASSWORD} --net test-network ${PHPMYADMIN_IMAGE}