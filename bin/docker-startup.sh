#!/bin/bash
BASE_DIR=/application

JAVA_OPT="$JAVA_OPT $JVM_OPTS"
JAVA_OPT="$JAVA_OPT $JVM_AGENT"
JAVA_OPT="$JAVA_OPT -Dserver.port=$SERVER_PORT"
JAVA_OPT="$JAVA_OPT org.springframework.boot.loader.JarLauncher"

echo "application is starting,you can check the ${BASE_DIR}/logs/start.out"
echo "java $JAVA_OPT" >$BASE_DIR/logs/start.log 2>&1 &
nohup java $JAVA_OPT >$BASE_DIR/logs/start.log 2>&1 </dev/null &
tail $BASE_DIR/logs/start.log -f