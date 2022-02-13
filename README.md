# jclipper-spring-webapp-template

## 更新记录

## 项目结构

```shell
.
├── Dockerfile  # Dockerfile
├── README.md   # README
├── .gitignore  # gitignore
├── bin
│   ├── docker-build.sh   # docker镜像构建脚本
│   └── docker-startup.sh # 服务在docker容器内启动脚本
├── deployment.yaml   # docker镜像在K8S中部署脚本
├── pom.xml 
├── <app-name>-model  # 项目model和常量module
│   ├── pom.xml
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── wf2311
│   │                   └── jclipper
│   │                       └── webapp
│   │                           ├── constants # 常量类包
│   │                           │   ├── ExampleCodeEnum.java
│   │                           │   └── ExampleErrorCodeEnum.java
│   │                           └── model # 实体类包
│   │                               ├── Example.java
│   │                               ├── request # 请求实体类
│   │                               │   └── ExampleRequest.java
│   │                               └── response  # 响应实体类
│   │                                   └── ExampleResponse.java
├── <app-name>-mq-model # MQ相关实体类
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── wf2311
│   │   │   │           └── jclipper
│   │   │   │               └── webapp
│   │   │   │                   └── mq
│   │   │   │                       └── model
│   │   │   │                           └── ExampleMqEvent.java
│   │   │   └── resources
│   │   └── test
│   │       └── java
├── <app-name>-remote-api   # 远程接口API
│   ├── pom.xml
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── wf2311
│   │                   └── jclipper
│   │                       └── webapp
│   │                           └── remote
│   │                               └── api
│   │                                   └── ExampleRemoteApi.java
├── <app-name>-webapp   # webapp,dao、service、facade、controller都放在此模块
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── wf2311
│   │   │   │           └── jclipper
│   │   │   │               └── webapp
│   │   │   │                   ├── JclipperWebappApplication.java
│   │   │   │                   ├── remote
│   │   │   │                   │   └── ExampleRemoteService.java
│   │   │   │                   └── controller
│   │   │   │                       └── ExampleController.java
│   │   │   └── resources
│   │   │       ├── bootstrap.yml
│   │   │       └── log4j2-spring.xml
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── wf2311
│   │                   └── jclipper
│   │                       └── webapp
│   │                           ├── SpringBootTests.java  # 测试用例基类
│   │                           ├── code
│   │                           │   └── generator # mybatis代码生成器
│   │                           │       ├── AbstractMyBatisCodeGenerator.java
│   │                           │       └── MyBatisCodeGenerator.java # mybatis代码生成器
│   │                           └── service
│   │                               └── ExampleServiceTest.java


```

## 项目依赖
### 公共依赖
| 依赖                                                 | 版本号          | 功能说明  |
|-----------------------------------------------------|--------------|-----------|
| org.springframework.boot:spring-boot-dependencies   | 2.4.2        | SpringBoot bom |
| org.springframework.cloud:spring-cloud-dependencies | 2020.0.0     | springCloud bom|
| com.alibaba.cloud:spring-cloud-alibaba-dependencies | 2021.1       | alibabaCloud bom |
| com.alibaba.nacos:nacos-client                      | 1.4.2        | nacos client  |
| org.apache.dubbo:dubbo                              | 2.7.12        | dubbo     |
| org.projectlombok:lombok                            | 1.18.12      | lombok    |
| com.google.guava:guava                              | 28.2-jre     | guava     |
| io.jsonwebtoken:jjwt                                | 0.9.1        | Jwt       |
| com.lmax:disruptor                                  | 3.4.4        | disruptor |
| io.netty:netty-all                                  | 4.1.58.Final | netty     |
| org.springframework.boot:spring-boot-starter-log4j2 | 2.4.2        | Log4j2    |
| org.springframework.boot:spring-boot-actuator       | 2.4.2        | actuator  |
| io.micrometer:micrometer-registry-prometheus        | 1.6.3        | prometheus|
| org.springframework.boot:spring-boot-starter-log4j2 | 2.4.2        | Log4j2    |
| org.mybatis.spring.boot:mybatis-spring-boot-starter | 2.2.0        | MyBatis   |
| org.springframework.boot:spring-boot-starter-test   | 2.4.2        | junit     |
| org.junit.jupiter:junit-jupiter-engine              | 5.7.0        | junit     |
| org.junit.platform:junit-platform-runner            | 1.7.0        | junit     |

### 内部依赖
| 依赖                                              | 版本号              | 功能说明                            | 是否必须 |
|-------------------------------------------------|------------------|---------------------------------|------|----------------------------------------------------------------------------------------------------------------|
| com.wf2311.jclipper:jclipper-framework-parent                     | 2021.06-SNAPSHOT | 公共bom                           | ✔️   |
| com.wf2311.jclipper:jclipper-common                         | 2021.06-SNAPSHOT | 公共基础包                           | ✔️   |
| com.wf2311.jclipper:jclipper-webapp-base                    | 2021.06-SNAPSHOT | jclipper webapp 基础依赖              | ✔️   |
| com.wf2311.jclipper:mybatis-plus-generator                | 2021.06-SNAPSHOT | MyBatisPlus扩展增强                 | ❌    | 
| com.baomidou:mybatis-plus-generator             | 3.3.1.tmp        | mybatis代码生成                     | ❌    | 
| com.wf2311.jclipper:exception-handler-spring-boot-starter | 2021.06-SNAPSHOT | 全局统一异常处理                        | ✔️   | 
| com.wf2311.jclipper:java-time-converter-spring-boot-starter | 2021.06-SNAPSHOT | java Date和java8 Time的序列化与反序列化   | ✔️   | 
| com.wf2311.jclipper:swagger-spring-boot-starter    | 2021.06-SNAPSHOT | swagger3，springfox3，使用knife4j增强 | ❌    |
| com.wf2311.jclipper:lettuce-spring-boot-starter           | 2021.06-SNAPSHOT | lettuce版的Redis客户端               | ❌    |

## 项目功能
项目依赖版本说明：

spring-webapp原型骨架项目：
1. 集成nacos配置管理功能，默认会读取groupId=`当前项目名`，如下5个dataId: 
   
   |  dataId | 说明  | 是否支持动态刷新  |
   |---|---|---|
   | config.properties  | 通用  |  ✔️ |
   | cache.properties  |  缓存配置 |  ❌ |
   | mq.properties  | MQ配置  |  ❌ |
   | db.properties  | 数据库配置  | ❌  |
   | log4j2-spring.xml  | log4j2配置  | ✔️  |
2. 集成nacos服务配置功能，注册的元数据中会携带服务启动时间；
3. 集成Dubbo远程调用，注册中心使用的SpringCloud；
4. 集成全局统一异常处理，详见`jclipper.springboot.exception.GlobalExceptionHandler`
   > 推荐使用，如下方式抛出业务异常：
   > 1. 枚举类`CommonErrorCode`；
   > 2. 实现`BaseErrorCode`自定义枚举类;
   > 3. 使用`CustomErrorCode`对象；
5. 集成swagger3，springfox3，使用knife4j增强，访问地址 ip:port/doc.html;
   > 生产环境要禁用此功能请添加配置：jclipper.swagger.enabled=false
6. java Date和java8 Time的序列化与反序列化，参见`ExampleController`和`DateModel`类；
7. 集成log4j2配置动态刷新功能，在nacos的配置中心中修改dataId=log4j2-spring.xml，即可实现日志配置的动态刷新；
   > 如果不想使用此功能，请设置jvm启动参数 -Dnacos.log4j2.dynamic.enabled=false ，或配置Spring参数 nacos.log4j2.dynamic.enabled=false
9. mybatis-plus generator,用法详见测试目录下的类`MyBatisCodeGenerator`；
10. 集成Gitlab CI脚本，采用layer分层构建Docker镜像；
11. README文件模板；


## 使用方式
使用一下命令并修改实际项目修改参数生成项目框架
```shell
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -B -DarchetypeGroupId=com.wf2311.jclipper.webapp \
    -DarchetypeArtifactId=jclipper-spring-webapp-template-archetype -DarchetypeVersion=2021.06-SNAPSHOT \
    -DarchetypeCatalog=http://192.168.20.62:8080/nexus/content/repositories/snapshots/archetype-catalog.xml \
    -DgroupId=<GROUP_ID> \
    -DartifactId=<ARTIFACT_ID> \
    -Dversion=<VERSION> \
    -Dpackage=<PACKAGE> -Dapplication=<SpringBootApplication> \
    -Dport=<SERVER_PORT>
```

参数说明：
- GROUP_ID：要创建项目的groupId
- ARTIFACT_ID：要创建项目的名称
- VERSION：要创建项目的版本号
- PACKAGE：要创建项目的包名
- SpringBootApplication：要创建项目的启动类名
- SERVER_PORT：要创建项目的启动端口号


例如：要创建一个 GROUP_ID=com.wf2311.jclipper.webapp，ARTIFACT_ID=jclipper-user，VERSION=1.0-SNAPSHOT，PACKAGE=com.wf2311.jclipper.webapp.user，
SpringBootApplication=UserSpringBootApplication,SERVER_PORT=9000 的项目，则运行如下命令：

- mac or linux
```shell
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -B -DarchetypeGroupId=com.wf2311.jclipper.webapp \
    -DarchetypeArtifactId=jclipper-spring-webapp-template-archetype -DarchetypeVersion=2022.1-SNAPSHOT \
    -DgroupId=com.wf2311.jclipper.webapp \
    -DartifactId=jclipper-user \
    -Dversion=1.0-SNAPSHOT \
    -Dpackage=com.wf2311.jclipper.webapp.user -Dapplication=UserSpringBootApplication \
    -Dport=9000
```

- windows
```shell
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -B -DarchetypeGroupId=com.wf2311.jclipper.webapp ^
    -DarchetypeArtifactId=jclipper-spring-webapp-template-archetype -DarchetypeVersion=2022.1-SNAPSHOT ^
    -DgroupId=com.wf2311.jclipper.webapp ^
    -DartifactId=jclipper-user ^
    -Dversion=1.0-SNAPSHOT ^
    -Dpackage=com.wf2311.jclipper.webapp.user -Dapplication=UserSpringBootApplication ^
    -Dport=9000
```
