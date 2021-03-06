package kuroneko.fun.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdServerHandler extends IdleStateHandler {

  /**
   * 设置空闲检测时间为 30s
   */
  private static final int READER_IDLE_TIME = 30;
  public IdServerHandler() {
    super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
  }

  @Override
  protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
    log.info("{} 秒内没有读取到数据,关闭连接", READER_IDLE_TIME);
    ctx.channel().close();
  }
}
