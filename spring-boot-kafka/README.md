# spring-boot-demo

## 1.配置Zookeeper
1. 下载并解压
```bash
wget http://ftp.jaist.ac.jp/pub/apache/zookeeper/stable/zookeeper-3.4.10.tar.gz
tar -xf zookeeper-3.4.10.tar.gz
```
2. 进入文件夹并复制一份配置文件
```bash
cd zookeeper-3.4.10
cp zoo_sample.cfg zoo.cfg
vim zoo.cfg
```

3. 编辑配置文件zoo.cfg
```bash
tickTime=2000
initLimit=10
syncLimit=5
clientPort=2181

server.1=165.227.119.201:2888:3888
server.2=165.227.119.247:2888:3888
server.3=159.203.175.6:2888:3888

dataDir=/opt/amqbroker/zookeeper/data
dataLogDir=/opt/amqbroker/zookeeper/log
```

4. 创建配置文件中所指定的dataDir,dataLogDir
```bash
mkdir -p /opt/amqbroker/zookeeper/data/
mkdir -p /opt/amqbroker/zookeeper/log/
```
5. 编写myid配置文件
配置文件中的server.n，需要将n写入到/opt/amqbroker/zookeeper/data/myid文件中
```bash
echo "n" > /opt/amqbroker/zookeeper/data/myid
```

## 2.启动Zookeeper

```bash
cd ~/zookeeper-3.4.10/
./bin/zkServer.sh start
```
1. 如果使用`./zkServer.sh start`启动成功，但是使用`./zkServer.sh status`查看状态报错Error
```bash
root@kafka-01:# ./bin/zkServer.sh status
ZooKeeper JMX enabled by default
Using config: /root/zookeeper-3.4.10/bin/../conf/zoo.cfg
Error contacting service. It is probably not running.
```

2. 如果返回结果中没有该进程则表示启动失败，不使用demon模式启动，可以查看到Debug的报错信息
```bash
./zkServer.sh start-foreground
```

3. 最后使用jps命令查看是否启动成功,如果返回结果中包含QuorumPeerMain进程则表示启动成功
```bash
root@kafka-01:# jps
7872 QuorumPeerMain
8982 Jps
```

## 3.配置Kafka
1. config/server.properties:  
```bash
broker.id=n
listeners=PLAINTEXT://:9092
zookeeper.connect=165.227.119.201:2181,165.227.119.247:2181,159.203.175.6:2181
```  

2. 将advertised.listeners配置追加到server.properties
```bash
echo "advertised.listeners=PLAINTEXT://you.host.name:9092" >> server.properties
```
## 4.启动Kafka

```bash
./bin/kafka-server-start.sh config/server.properties
```

1. 如果出现内存不足
```bash
root@kafka-02:# ./bin/kafka-server-start.sh config/server.properties
Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000000c0000000, 1073741824, 0) failed; error='Cannot allocate memory' (errno=12)
#
# There is insufficient memory for the Java Runtime Environment to continue.
# Native memory allocation (mmap) failed to map 1073741824 bytes for committing reserved memory.
# An error report file with more information is saved as:
# /root/kafka_2.11-0.11.0.1/hs_err_pid6183.log
```
解决办法： 修改KAFKA_HEAP_OPTS内存值
```bash
export KAFKA_HEAP_OPTS="-Xmx1G -Xms1G"
```
修改为
```bash
export KAFKA_HEAP_OPTS="-Xmx256M -Xms128M"
```
[kafka 启动 报错cannot allocate memory，即内存不足](http://blog.csdn.net/gywtzh0889/article/details/51773536)

2. 创建Topic
```bash
./kafka-topics.sh --create --zookeeper 165.227.119.201:2181,165.227.119.247:2181,159.203.175.6:2181 --replication-factor 2 --partitions 1 --topic shuaige
#解释
--replication-factor 2   #复制两份
--partitions 1 #创建1个分区
--topic #主题为shuaige
```
在一台服务器上创建一个发布者
```bash
./kafka-console-producer.sh --broker-list 165.227.119.201:9092,165.227.119.247:9092,159.203.175.6:9092 --topic shuaige
```
在一台服务器上创建一个订阅者
```bash
./kafka-console-consumer.sh --zookeeper 165.227.119.201:2181,165.227.119.247:2181,159.203.175.6:2181 --topic shuaige --from-beginning
```
# 引用
[技术世界 - Kafka,SQL,PostgreSQL,数据库,大数据,分布式,集群,云计算,云计算cloud,Java,设计模式](http://www.jasongj.com/)