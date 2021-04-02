//package kuroneko.fun.netty.server.encoder;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.MessageToByteEncoder;
//import java.nio.charset.StandardCharsets;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class StringEncoder extends MessageToByteEncoder<String> {
//
//  @Override
//  protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
//    byte[] length = "this is the Server".getBytes(StandardCharsets.UTF_8);
//    byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
//    if (bytes.length<length.length){
//      return;
//    }
//    out.writeBytes(bytes);
//  }
//}
