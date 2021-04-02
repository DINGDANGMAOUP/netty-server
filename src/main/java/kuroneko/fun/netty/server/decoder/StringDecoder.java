//package kuroneko.fun.netty.server.decoder;
//
//import io.netty.buffer.ByteBuf;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class StringDecoder extends ByteToMessageDecoder {
//
//  @Override
//  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//    byte[] length = "this is the client".getBytes(StandardCharsets.UTF_8);
//    if (in.readableBytes() < length.length) {
//      return;
//    }
//    CharSequence charSequence = in.readCharSequence(length.length, StandardCharsets.UTF_8);
//    out.add(charSequence);
//  }
//}
