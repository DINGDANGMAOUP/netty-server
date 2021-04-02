//package kuroneko.fun.netty.server.encoder;
//
//import com.google.protobuf.ByteString;
//import io.grpc.protobuf.ProtoUtils;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.ByteBufUtil;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.handler.codec.MessageToByteEncoder;
//import io.netty.handler.codec.protobuf.ProtobufDecoder;
//import java.nio.charset.StandardCharsets;
//import kuroneko.fun.netty.server.proto.MessageProto;
//import kuroneko.fun.netty.server.proto.MessageProto.Message;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ProtoEncoder extends MessageToByteEncoder<MessageProto.Message> {
//
//
//  @Override
//  protected void encode(ChannelHandlerContext ctx, MessageProto.Message msg,
//      ByteBuf out) throws Exception {
////    ByteString build = MessageProto.Message.newBuilder().setMsg("this is the server").build().getMsgBytes();
////    ByteString msgBytes = msg.getMsgBytes();
////    if (msgBytes.size()<build.size()){
////      return;
////    }
////    log.info("byte:"+new byte[]{msgBytes.byteAt(build.size())});
////    log.info("msg:"+msg);
//    out.writeBytes(msg.getMsg().getBytes());
//  }
//}
