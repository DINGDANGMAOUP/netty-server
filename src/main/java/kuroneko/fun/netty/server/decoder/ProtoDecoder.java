//package kuroneko.fun.netty.server.decoder;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import kuroneko.fun.netty.server.proto.MessageBase.Message;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ProtoDecoder extends ByteToMessageDecoder {
//
//  @Override
//  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in,
//      List<Object> out)  {
//    byte[] length = Message.newBuilder().setContent("this is the server").getMs
//        .toByteArray();
//
//    if (in.readableBytes() < length.length) {
//      return;
//    }
//    CharSequence charSequence = in.readCharSequence(length.length,StandardCharsets.UTF_8);
//    out.add(charSequence);
//    log.info("charSequence:"+charSequence);
//    log.info("in:"+in);
//  }
//}
