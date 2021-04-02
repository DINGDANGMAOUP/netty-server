package kuroneko.fun.netty.server.utils;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import kuroneko.fun.netty.server.handler.ServerInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/** @author kuroneko */
@Slf4j
@Component
public class ServerBootStrap {
  private final NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
  private final NioEventLoopGroup workerGroup = new NioEventLoopGroup(200);
  private Channel channel;

  public ChannelFuture start(String host, int port) {
    InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);
    ChannelFuture channelFuture = null;
    try {
      ServerBootstrap serverBootstrap =
          new ServerBootstrap()
              .group(bossGroup, workerGroup)
              .channel(NioServerSocketChannel.class)
              .childHandler(new ServerInitializer())
              .localAddress(inetSocketAddress)
              .option(ChannelOption.SO_BACKLOG, 1024)
              .childOption(ChannelOption.SO_KEEPALIVE, true);
      channelFuture = serverBootstrap.bind().sync();
      channel = channelFuture.channel();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (channelFuture != null && channelFuture.isSuccess()) {
        log.info("server start");
        log.info("server listening " + host + " on port " + port + " and ready for connections...");
      } else {
        log.error("server start up Error!");
      }
    }
    return channelFuture;
  }
  /** 停止服务 */
  public void destroy() {
    log.info("Shutdown Netty Server...");
    if (channel != null) {
      channel.close();
    }
    workerGroup.shutdownGracefully();
    bossGroup.shutdownGracefully();
    log.info("Shutdown Netty Server Success!");
  }
}
