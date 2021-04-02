package kuroneko.fun.netty.server.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import kuroneko.fun.netty.server.decoder.Decoder;
import kuroneko.fun.netty.server.encoder.Encoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {

    ch.pipeline().addLast(new Encoder());
    ch.pipeline().addLast(new Decoder());
    ch.pipeline().addLast(new ServerHandler());
    ch.pipeline().addLast(new IdServerHandler());
  }
}
