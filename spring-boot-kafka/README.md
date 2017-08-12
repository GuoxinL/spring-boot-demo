# spring-boot-demo

## 1.进入到kafka消息中间件的目录
`cd cd software/kafka_2.12-0.11.0.0`  

## 2.启动Zookeeper
`./bin/zookeeper-server-start.sh config/zookeeper.properties`

## 3.修改节点配置文件
config/server-0.properties:  
`broker.id=0`  
`listeners=PLAINTEXT://:9092`  
`log.dir=/tmp/kafka-logs-0`  

config/server-1.properties:  
`broker.id=1`  
`listeners=PLAINTEXT://:9093`  
`log.dir=/tmp/kafka-logs-1`  

config/server-2.properties:  
`broker.id=2`  
`listeners=PLAINTEXT://:9094`  
`log.dir=/tmp/kafka-logs-2`  

## 4.启动Kafka

`./bin/kafka-server-start.sh config/server-0.properties`  
`./bin/kafka-server-start.sh config/server-1.properties`  
`./bin/kafka-server-start.sh config/server-2.properties`  