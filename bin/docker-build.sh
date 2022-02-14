#!/bin/bash

#项目名称
APP_NAME='jclipper-spring-webapp-template'
#项目启动端口号
SERVER_PORT='<PORT>'
#项目启动需要附加的jvm参数
JVM_OPTS='-Xmx256m -Xms128m -Xss512k'
#项目打包上传的docker仓库地址
REGISTRY_HOST='harbor.wf2311.com'
#项目打包的镜分组
REGISTRY_GROUP='jclipper-docker-local'
#项目打包的镜像名称
REGISTRY_IMAGE='jclipper-spring-webapp-template:1.0'
#远程docker仓库登录用户名
REGISTRY_USER='admin'
#远程docker仓库登录密码
REGISTRY_PASSWORD='Password@1'

cd ../
echo "stage mvn package"
mvn -DskipTests package

echo "build and push docker image"

docker login -u $REGISTRY_USERNAME -p $REGISTRY_PASSWORD $REGISTRY_HOST
docker build --build-arg APP_NAME=$APP_NAME -t $REGISTRY_HOST/$REGISTRY_GROUP/$REGISTRY_IMAGE .
docker push $REGISTRY_HOST/$REGISTRY_GROUP/$REGISTRY_IMAGE
