package kuroneko.fun.netty.server;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Slf4j
public class NettyServerDemoApplication  {


    public static void main(String[] args) {

        SpringApplication.run(NettyServerDemoApplication.class, args);
    }
    @Service
    @RocketMQMessageListener(topic = "TopicTest", consumerGroup = "my-consumer_TopicTest")
     class MyConsumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            log.info("received message: " + message);
        }
    }

}
