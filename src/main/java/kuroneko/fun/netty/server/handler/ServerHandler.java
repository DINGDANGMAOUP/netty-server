package kuroneko.fun.netty.server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kuroneko.fun.netty.server.proto.MessageBase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Sharable
public class ServerHandler extends SimpleChannelInboundHandler<MessageBase.Message> {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {

      MessageBase.Message message1 = MessageBase.Message.newBuilder().setContent("this is the server").build();
      ctx.channel().writeAndFlush(message1);
    log.info("server active...");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    log.info("server inactive...");
  }


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MessageBase.Message message)
      throws Exception {
      MsgHandler msgHandler = new MsgHandler();
      msgHandler.response(message);
      MessageBase.Message message1 = MessageBase.Message.newBuilder().setContent("msg over").build();
      ctx.channel().writeAndFlush(message1);
  }

//  @Override
//  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//    MsgHandler msgHandler = new MsgHandler();
//    msgHandler.response(msg);
//    ctx.channel().writeAndFlush("消息已处理");
//
//  }
}
