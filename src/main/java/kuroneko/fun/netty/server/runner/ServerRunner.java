package kuroneko.fun.netty.server.runner;

import io.netty.channel.ChannelFuture;
import javax.annotation.Resource;
import kuroneko.fun.netty.server.config.ServerConfig;
import kuroneko.fun.netty.server.utils.ServerBootStrap;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class ServerRunner implements ApplicationRunner {

  @Resource
  ServerConfig serverConfig;
  @Resource
  ServerBootStrap serverBootStrap;

  @Override
  public void run(ApplicationArguments args)  {
    ChannelFuture future = serverBootStrap.start(serverConfig.getIp(), serverConfig.getPort());
    Runtime.getRuntime().addShutdownHook(
        new Thread(){
      @Override
      public void run(){
        serverBootStrap.destroy();
      }
    });
    future.channel().closeFuture().syncUninterruptibly();


  }
}
