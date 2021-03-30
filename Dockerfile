# Docker image for springboot file run
# VERSION 0.0.1
# Author: jollyja
# 基础镜像使用java
FROM centos:8
# 作者
MAINTAINER jollyja <jollyja@263.net>

# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# docker启动的时候由外部映射jdk
VOLUME /JDK

EXPOSE 8081

# 设置环境变量
ENV JAVA_HOME /JDK
ENV PATH /JDK/bin:$PATH

ARG JAR_FILE=target/*[^without-dependency].jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
