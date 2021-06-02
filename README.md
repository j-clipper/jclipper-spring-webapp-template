# 使用方式

```shell
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -B -DarchetypeGroupId=com.wf2311.lib \
    -DarchetypeArtifactId=spring-app-template-archetype -DarchetypeVersion=2021.04-SNAPSHOT \
    -DarchetypeCatalog=https://oss.sonatype.org/content/repositories/snapshots/archetype-catalog.xml \
    -Dversion=1.0-SNAPSHOT \
    -DgroupId=com.wf2311 \
    -DartifactId=rabbitmq-in-action \
    -Dpackage=com.wf2311.rabbitmq.inaction -Dapplication=RabbitMqInActionApplication \
    -Dport=10011
```