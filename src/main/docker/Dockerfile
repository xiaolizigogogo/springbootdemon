FROM openjdk:8-jre-alpine
MAINTAINER JML

ENV PROJECT_VERSION @project.version@
ENV ENV @profile@
RUN echo "http://mirrors.aliyun.com/alpine/v3.6/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.6/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone
RUN mkdir /opt/data

ADD @project.artifactId@-${PROJECT_VERSION}.jar @project.artifactId@.jar

ENTRYPOINT ["java","-jar","/@project.artifactId@.jar","--spring.profiles.active=@profile@","-Ddev_meta=http://apollo-configservice:8080"]